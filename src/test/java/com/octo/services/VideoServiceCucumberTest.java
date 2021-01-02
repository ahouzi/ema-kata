package com.octo.services;

import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:Feature")
public class VideoServiceTest {


    @InjectMocks
    private VideoService videoService;
    @Mock
    private VideoRepository videoRepository;
    @Mock
    private VideoToVideoDTOMapper videoToVideoDTOMapper;



    @When("When users want to get videos without params")
    public void retrieveVideoByTagsAndOrLevel_noParams() {
        Video videoOne = new Video("1", "title_1", "description_1", "url_1", 1.0, Level.EASY, Arrays.asList("tech", "game"));
		Video videoTwo = new Video("2", "title_2", "description_2", "url_2", 2.0, Level.EASY, Arrays.asList("talk"));

		List<VideoDTO> list = new ArrayList<>();
		list.add(videoToVideoDTOMapper.convert(videoOne));
		list.add(videoToVideoDTOMapper.convert(videoTwo));
		when(videoService.retrieveVideosByTagAndLevel(null, null)).thenReturn(list);

		List<VideoDTO> results = videoService.retrieveVideosByTagAndLevel(null, null);
		assertEquals(results.size(), 2);
    }
    @When("When users want to get videos with level")
    public void retrieveVideoByTagsAndOrLevel_withLevel() {
        Video videoOne = new Video("1", "title_1", "description_1", "url_1", 1.0, Level.EASY, Arrays.asList("tech", "game"));
		Video videoTwo = new Video("2", "title_2", "description_2", "url_2", 2.0, Level.EASY, Arrays.asList("talk"));

		List<VideoDTO> list = new ArrayList<>();
		list.add(videoToVideoDTOMapper.convert(videoOne));
		list.add(videoToVideoDTOMapper.convert(videoTwo));
		when(videoService.retrieveVideosByTagAndLevel(null, Level.EASY)).thenReturn(list);

		List<VideoDTO> results = videoService.retrieveVideosByTagAndLevel(null, Level.EASY);
		assertEquals(results.size(), 2);
    }

    @When("When users want to get videos with tags")
    public void retrieveVideoByTagsAndOrLevel_withTags() {
        Video videoOne = new Video("1", "title_1", "description_1", "url_1", 1.0, Level.EASY, Arrays.asList("tech", "game"));
		Video videoTwo = new Video("2", "title_2", "description_2", "url_2", 2.0, Level.EASY, Arrays.asList("talk"));

		List<VideoDTO> list = new ArrayList<>();
		list.add(videoToVideoDTOMapper.convert(videoOne));
		list.add(videoToVideoDTOMapper.convert(videoTwo));
		when(videoService.retrieveVideosByTagAndLevel(Arrays.asList("talk"), null)).thenReturn(list);

		List<VideoDTO> results = videoService.retrieveVideosByTagAndLevel(Arrays.asList("talk"), null);
		assertEquals(results.size(), 1);
    }

    @When("When users want to get videos with tags and level")
    public void retrieveVideoByTagsAndOrLevel_withTagsAndLevel() {
        Video videoOne = new Video("1", "title_1", "description_1", "url_1", 1.0, Level.EASY, Arrays.asList("tech", "game"));
		Video videoTwo = new Video("2", "title_2", "description_2", "url_2", 2.0, Level.EASY, Arrays.asList("talk"));

		List<VideoDTO> list = new ArrayList<>();
		list.add(videoToVideoDTOMapper.convert(videoOne));
		list.add(videoToVideoDTOMapper.convert(videoTwo));
		when(videoService.retrieveVideosByTagAndLevel(Arrays.asList("talk"), Level.EASY)).thenReturn(list);

		List<VideoDTO> results = videoService.retrieveVideosByTagAndLevel(Arrays.asList("talk"), Level.EASY);
		assertEquals(results.size(), 1);
    }


}