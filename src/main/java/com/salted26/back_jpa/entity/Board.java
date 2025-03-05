package com.salted26.back_jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(name="id", nullable=false, unique=true)
    private String id;
    @Column(name="title")
    private String title;
    @Column(name="writer")
    private String writer;
    @Column(name="content")
    private String content;
    @Column(name="views")
    private int views;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updated_at;

}
