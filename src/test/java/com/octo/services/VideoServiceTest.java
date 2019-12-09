package com.octo.services;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VideoServiceTest {

	@InjectMocks
	private VideoService videoService;
	@Mock
	private VideoRepository videoRepository;
	@Mock
	private VideoToVideoDTOMapper videoToVideoDTOMapper;

	@Test
	public void retrieveVideoByTagsAndOrLevel_test_WithoutInputs() {

		Video v1 = new Video("12", "title1", "desc1", "url1", 3.54, Level.MEDIUM, Arrays.asList("Sport", "Casablanca"));
		Video v2 = new Video("13", "title2", "desc2", "url2", 6.54, Level.EASY, Arrays.asList("Casablanca", "Morocco"));
		Video v3 = new Video("14", "title3", "desc3", "url3", 9.54, Level.EASY, Arrays.asList("Sky", "Bird"));

		List<VideoDTO> list = new ArrayList<>();
		list.add(videoToVideoDTOMapper.convert(v1));
		list.add(videoToVideoDTOMapper.convert(v2));
		list.add(videoToVideoDTOMapper.convert(v3));
		when(videoService.retrieveVideosByTagAndLevel(null, null)).thenReturn(list);

		List<VideoDTO> actualList = videoService.retrieveVideosByTagAndLevel(null, null);
		assertEquals(actualList.size(), 3);
	}

	@Test
	public void retrieveVideoByTagsAndOrLevel_test_WithLevel() {

		Video v1 = new Video("12", "title1", "desc1", "url1", 3.54, Level.MEDIUM, Arrays.asList("Sport", "Casablanca"));
		Video v2 = new Video("13", "title2", "desc2", "url2", 6.54, Level.EASY, Arrays.asList("Casablanca", "Morocco"));
		Video v3 = new Video("14", "title3", "desc3", "url3", 9.54, Level.EASY, Arrays.asList("Sky", "Bird"));

		List<VideoDTO> list = new ArrayList<>();
		list.add(videoToVideoDTOMapper.convert(v2));
		list.add(videoToVideoDTOMapper.convert(v3));
		when(videoService.retrieveVideosByTagAndLevel(null, Level.EASY)).thenReturn(list);

		List<VideoDTO> actualList = videoService.retrieveVideosByTagAndLevel(null, Level.EASY);
		assertEquals(actualList.size(), 2);
	}
	
	@Test
	public void retrieveVideoByTagsAndOrLevel_test_WithTags() {

		Video v1 = new Video("12", "title1", "desc1", "url1", 3.54, Level.MEDIUM, Arrays.asList("Sport", "Casablanca"));
		Video v2 = new Video("13", "title2", "desc2", "url2", 6.54, Level.EASY, Arrays.asList("Casablanca", "Morocco"));
		Video v3 = new Video("14", "title3", "desc3", "url3", 9.54, Level.EASY, Arrays.asList("Sky", "Bird"));

		List<VideoDTO> list = new ArrayList<>();
		list.add(videoToVideoDTOMapper.convert(v3));
		when(videoService.retrieveVideosByTagAndLevel(Arrays.asList("Bird"), null)).thenReturn(list);

		List<VideoDTO> actualList = videoService.retrieveVideosByTagAndLevel(Arrays.asList("Bird"), null);
		assertEquals(actualList.size(), 1);
	}

	@Test
	public void retrieveVideoByTagsAndOrLevel_test_WithLevelAndTags() {

		Video v1 = new Video("12", "title1", "desc1", "url1", 3.54, Level.MEDIUM, Arrays.asList("Sport", "Casablanca"));
		Video v2 = new Video("13", "title2", "desc2", "url2", 6.54, Level.EASY, Arrays.asList("Casablanca", "Morocco"));
		Video v3 = new Video("14", "title3", "desc3", "url3", 9.54, Level.EASY, Arrays.asList("Sky", "Bird"));

		List<VideoDTO> list = new ArrayList<>();
		list.add(videoToVideoDTOMapper.convert(v2));
		when(videoService.retrieveVideosByTagAndLevel(Arrays.asList("Casablanca"), Level.EASY)).thenReturn(list);

		List<VideoDTO> actualList = videoService.retrieveVideosByTagAndLevel(Arrays.asList("Casablanca"), Level.EASY);
		assertEquals(actualList.size(), 1);
	}

}