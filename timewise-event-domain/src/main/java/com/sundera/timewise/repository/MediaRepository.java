package com.sundera.timewise.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sundera.timewise.domain.MediaFile;

public interface MediaRepository extends JpaRepository<MediaFile,Long> {
	MediaFile findByUserIdAndName(String userId, UUID name);
}
