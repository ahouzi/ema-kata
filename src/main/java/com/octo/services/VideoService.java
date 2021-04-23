package com.octo.services;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.text.ViewFactory;

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

    EntityManager em;


    public List<VideoDTO> retrieveVideosByTagAndLevel(List<String> tags, Level level) {

        // TODO code goes here
        // 1. search videos by tags AND/OR level don't use a simple @QUERY
        
        // CriteriaBuilder cb = em.getCriteriaBuilder();
        // CriteriaQuery<Video> cq = cb.createQuery(Video.class);

        List<Video> videos = videoRepository.findAll();

        // 2. use videoToVideoDTOMapper to map videos to videos DTO
        List<VideoDTO> videosDTO = videos.stream().map(t -> videoToVideoDTOMapper.convert(t)).collect(Collectors.toList());

        // 3 return the list
        return videosDTO;
    }


}
