package com.octo.services;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		return videoRepository.findByLevelAndTags(level, tags).stream().map(videoToVideoDTOMapper::convert).collect(Collectors.toList());
	}
}
