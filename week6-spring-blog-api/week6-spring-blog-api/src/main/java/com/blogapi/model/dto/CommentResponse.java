package com.blogapi.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {
    private Long id;
    private String content;
    private String author;
    private Long postId;
    private String postTitle;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
