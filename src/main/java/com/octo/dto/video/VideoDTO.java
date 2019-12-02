package com.octo.dto.video;

import com.octo.domain.enums.Level;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class VideoDTO implements Serializable {

    private String id;
    private String title;
    private String description;
    private String url;
    private Double duration;
    private Level level;
    private List<String> tags = new ArrayList<>();

}
