package com.salted26.back_jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

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

    public void update(Board board) {
        this.no = board.getNo();
        this.id = board.getId();
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.content = board.getContent();
        this.views = board.getViews();
        this.created_at = board.getCreated_at();
        this.updated_at = board.getUpdated_at();
    }

}
