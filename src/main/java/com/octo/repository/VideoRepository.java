package com.octo.repository;


import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, String>, JpaSpecificationExecutor<Video> {
    List<Video> getVideosByTagsAndLevel(List<String> tags, Level level);
    List<Video> getVideosByTags(List<String> tags);
    List<Video> getVideosByLevel(Level level);

}
