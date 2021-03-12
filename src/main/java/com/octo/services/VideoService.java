package com.octo.services;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VideoService.class);

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoToVideoDTOMapper videoToVideoDTOMapper;



    public List<VideoDTO> retrieveVideosByTagAndLevel(List<String> tags, Level level) {

        // TODO code goes here
        List<Video> videos;
        // 1. search videos by tags AND/OR level
        if(level==null){
            LOGGER.info("SEARCHING BY TAGS...");
            videos = videoRepository.getVideosByTags(tags);
        }else if(tags.isEmpty()){
            LOGGER.info("SEARCHING BY LEVEL...");
            videos = videoRepository.getVideosByLevel(level);
        }else{
            LOGGER.info("SEARCHING BY TAGS & LEVEL...");
            videos = videoRepository.getVideosByTagsAndLevel(tags, level);
        }

        // 2. use videoToVideoDTOMapper to map videos to videos DTO
        List<VideoDTO> videoDTOS = new ArrayList<>();
        for(Video v: videos)
            videoDTOS.add(videoToVideoDTOMapper.convert(v));
        // 3 return the list

        return videoDTOS;
    }

    public List<VideoDTO> retrieveAllVideos(){

        LOGGER.info("FETCHING * VIDEOS...");
        List<Video> videos = videoRepository.findAll();
        List<VideoDTO> videoDTOS = new ArrayList<>();
        for(Video v: videos)
            videoDTOS.add(videoToVideoDTOMapper.convert(v));

        return videoDTOS;

    }


}
