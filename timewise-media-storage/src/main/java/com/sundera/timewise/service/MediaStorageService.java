package com.sundera.timewise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sundera.timewise.mediadomain.MediaFileDomain;
import com.sundera.timewise.repository.MediaRepository;

@Service
public class MediaStorageService {
	//private final String Folder_Path;
	@Autowired
	private MediaRepository mediaRepos;
	public String uploadImageFileSystem(MultipartFile file) {
		//MediaFileDomain mediaFileData = new MediaFileDomain(file.getOriginalFilename(),file.getContentType(),)
		return null;
		
	}
}
