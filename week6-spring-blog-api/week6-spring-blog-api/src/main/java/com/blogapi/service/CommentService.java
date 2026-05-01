package com.blogapi.service;

import com.blogapi.exception.ResourceNotFoundException;
import com.blogapi.model.dto.CommentRequest;
import com.blogapi.model.dto.CommentResponse;
import com.blogapi.model.entity.Comment;
import com.blogapi.model.entity.Post;
import com.blogapi.repository.CommentRepository;
import com.blogapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private static final Logger log = LoggerFactory.getLogger(CommentService.class);

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<CommentResponse> getCommentsByPost(Long postId) {
        log.debug("Fetching comments for post id: {}", postId);
        if (!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException("Post", "id", postId);
        }
        return commentRepository.findByPostId(postId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public CommentResponse addComment(Long postId, CommentRequest request) {
        log.debug("Adding comment to post id: {}", postId);
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        Comment comment = Comment.builder()
                .content(request.getContent())
                .author(request.getAuthor())
                .post(post)
                .build();

        Comment saved = commentRepository.save(comment);
        log.info("Added comment with id: {} to post id: {}", saved.getId(), postId);
        return mapToResponse(saved);
    }

    public CommentResponse updateComment(Long commentId, CommentRequest request) {
        log.debug("Updating comment with id: {}", commentId);
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        comment.setContent(request.getContent());
        comment.setAuthor(request.getAuthor());

        Comment updated = commentRepository.save(comment);
        log.info("Updated comment with id: {}", updated.getId());
        return mapToResponse(updated);
    }

    public void deleteComment(Long commentId) {
        log.debug("Deleting comment with id: {}", commentId);
        if (!commentRepository.existsById(commentId)) {
            throw new ResourceNotFoundException("Comment", "id", commentId);
        }
        commentRepository.deleteById(commentId);
        log.info("Deleted comment with id: {}", commentId);
    }

    private CommentResponse mapToResponse(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .author(comment.getAuthor())
                .postId(comment.getPost().getId())
                .postTitle(comment.getPost().getTitle())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}
