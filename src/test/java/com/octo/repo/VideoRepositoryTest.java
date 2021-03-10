package com.octo.repo;

import javax.transaction.Transactional;
import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.repository.VideoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class VideoRepositoryTest {

    @Autowired
    private VideoRepository videoRepository;

    private List<String> tags = new ArrayList<>();
    private Video video = new Video();

    @Before
    public void init(){
        tags.add("CALCUL");
        video.setId("200");video.setLevel(Level.MEDIUM);video.setTags(tags);video.setDuration(2.0);video.setTitle("lol");video.setDescription("ha");
        video.setUrl("url");
    }



    @Test
    public void findAll() {

        Assert.assertNotNull(videoRepository.save(video));

        Assert.assertEquals(videoRepository.findAll().size(), 1);
    }

    @Test
    public void save() {

        Assert.assertNotNull(videoRepository.save(video));
    }

}
