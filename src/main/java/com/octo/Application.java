package com.octo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.repository.VideoRepository;
import com.octo.services.VideoService;

@SpringBootApplication
@EnableCaching
public class Application {
	
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
