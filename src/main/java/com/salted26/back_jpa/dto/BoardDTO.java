package com.salted26.back_jpa.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long no;
    private String id;
    private String title;
    private String writer;
    private String content;
    private int views;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
