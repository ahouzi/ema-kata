package com.octo.services;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class VideoServiceTest {


    @InjectMocks
    private VideoService videoService;
    @Mock
    private VideoRepository videoRepository;
    @Mock
    private VideoToVideoDTOMapper videoToVideoDTOMapper;


    private List<String> tags = new ArrayList<>();
    private Video video = new Video();
    private List<Video> videos = new ArrayList<>();
    private List<VideoDTO> videoDTOS = new ArrayList<>();

    @Before
    public void init(){
        tags.add("CALCUL");
        video.setId("200");video.setLevel(Level.MEDIUM);video.setTags(tags);video.setDuration(2.0);video.setTitle("lol");video.setDescription("ha");
        video.setUrl("url");
        videos.add(video);

        videoDTOS.add(videoToVideoDTOMapper.convert(video));
    }



    @Test
    public void retrieveVideoByTagsAndOrLevel_test() {
        // save video
        when(videoRepository.save(Mockito.any(Video.class))).thenReturn(video);

        // assert that video is saved
        Assert.assertNotNull(videoRepository.save(video));

        // verifier nombre d'invocations de la méthode VideoRepository#save
        verify(videoRepository, times(1)).save(video);

        // when retrievevideos invoquée
        when(videoService.retrieveVideosByTagAndLevel(tags, Level.MEDIUM)).thenReturn(videoDTOS);

        // appeler la méthode retrievevideosbytagandlevel
        List<VideoDTO> retrievedDTOS = videoService.retrieveVideosByTagAndLevel(tags, Level.MEDIUM);

        Assert.assertEquals(retrievedDTOS.size(), 1);


    }



}