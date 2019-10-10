package com.octo.services;

import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;
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
    public void retrieveVideoByTagsAndOrLevel_test() {

    }


}