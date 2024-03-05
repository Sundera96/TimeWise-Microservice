package com.sundera.timewise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.sundera.timewise.exceptions.ImageNotFoundException;
import com.sundera.timewise.exceptions.NotAnImageException;
import com.sundera.timewise.response.MediaFileResponse;
import com.sundera.timewise.service.MediaService;

@RestController
@RequestMapping("/image")
public class MediaController {
	
	@Autowired
	private MediaService mediaService;

	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestHeader(value="userId") String userId, @RequestParam("image")MultipartFile file){
		System.out.print("Inside upload Image Controller");
		try{
			String response = mediaService.uploadImage(userId, file);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch (NotAnImageException notAnImageException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Upload only images");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/{filename}")
	public ResponseEntity<?> downloadImage(@RequestHeader(value="userId") String userId, @PathVariable String filename){
		try {
			MediaFileResponse file=mediaService.downloadImage(userId, filename);
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(file.getContentType())).body(file.getData());
		}catch(ImageNotFoundException imageNotFoundException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not Found");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
}
