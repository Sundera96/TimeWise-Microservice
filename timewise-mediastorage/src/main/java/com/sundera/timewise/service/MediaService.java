package com.sundera.timewise.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.sundera.timewise.domain.MediaFile;
import com.sundera.timewise.exceptions.ImageNotFoundException;
import com.sundera.timewise.exceptions.NotAnImageException;
import com.sundera.timewise.repository.MediaRepository;
import com.sundera.timewise.response.MediaFileResponse;

@Service
public class MediaService {
	
	private static String UPLOAD_DIRECTORY = System.getProperty("user.home")+"/TimieWiseUploads";
	
	@Autowired
	private MediaRepository mediaRepo;

	public String uploadImage(String userId,MultipartFile file) throws IllegalStateException, IOException, NotAnImageException {
		String[] fileTypeArr = file.getContentType().split("/");
		if(!fileTypeArr[0].equals("image")) {
			throw new NotAnImageException("Not an Image");
		}
		String fileName = UUID.randomUUID().toString()+'.'+fileTypeArr[1];
		Path directory = Paths.get(UPLOAD_DIRECTORY,userId);
		if(!Files.exists(directory)) {
			Files.createDirectories(directory);
		}
		MediaFile myFile = new MediaFile(fileName,file.getContentType(),userId);
		myFile=mediaRepo.save(myFile);
		if(myFile!=null)
			Files.write(getCompletePathOfFile(directory,fileName), file.getBytes());
		return "File Uploaded!";
	}
	
	public MediaFileResponse downloadImage(String userId, String fileName) throws IOException, ImageNotFoundException {
		MediaFile file = mediaRepo.findByUserIdAndName(userId, fileName);
		if(file==null) {
			throw new ImageNotFoundException("Image Not Found");
		}
		Path directory = Paths.get(UPLOAD_DIRECTORY,userId);
		byte[] data = Files.readAllBytes(new File(getCompletePathOfFile(directory,fileName).toString()).toPath());
		String dataType = file.getType();
		return new MediaFileResponse(data, dataType);
	}
	
	
	private Path getCompletePathOfFile(Path dir, String name) {
		return Paths.get(dir.toString(),name.toString());
	}
}
