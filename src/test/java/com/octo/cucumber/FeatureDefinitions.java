package com.octo.cucumber;


import com.octo.domain.enums.Level;
import com.octo.dto.video.VideoDTO;
import com.octo.holders.ApiPaths;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.List;


@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FeatureDefinitions {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplate restTemplate;
    private String retrieveHost = "https://localhost";

    @Given("je peux voir toutes les videos disponibles")
    public void FindVideosByTagAndLevel() throws URISyntaxException {
        String url = retrieveHost + ":" + port + ApiPaths.V1 + ApiPaths.ALLVIDEOS;
        List<VideoDTO> allVideoDTOS = restTemplate.getForObject(url, List.class);

        Assert.assertNotEquals(allVideoDTOS.size(), 0);

        log.info("Videos retrieved: " + allVideoDTOS);
    }

    @Given("^Jenvoie ma requete pour les videos ayant les tags (.*) et le Niveau (.*)$")
    public void getFoundResults(String tags, String lvl){

        String apiParams = "?level=" + lvl + "&tags=" + tags;
        String url = retrieveHost + ":" + port + ApiPaths.V1 + ApiPaths.VIDEOS + apiParams;

        List<VideoDTO> videoDTOS = restTemplate.getForObject(url, List.class);
        log.info("Videos retrieved by tag & level: " + videoDTOS);
    }
}
