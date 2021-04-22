package com.octo.repository;


import java.util.List;


import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VideoRepository extends JpaRepository<Video, String>, JpaSpecificationExecutor<Video> {
    List<Video> findByTags(List<String> tags);
    List<Video> findByLevel(Level level);
    
}
