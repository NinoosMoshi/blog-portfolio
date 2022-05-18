package com.ninos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;

    public PostDto(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }
}
