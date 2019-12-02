package com.octo.repository;


import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface VideoRepository extends JpaRepository<Video, String>, JpaSpecificationExecutor<Video> {
	
	/*
	 * @Query("SELECT v FROM video v, video_tags vt WHERE v.level = ?1 and vt.tags = ?2"
	 * ) public List<Video> filterByLevelandTags(Level level, List<String> tags);
	 */
}
