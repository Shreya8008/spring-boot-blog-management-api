package com.blogapi;

import com.blogapi.exception.ResourceNotFoundException;
import com.blogapi.model.dto.PostRequest;
import com.blogapi.model.dto.PostResponse;
import com.blogapi.model.entity.Category;
import com.blogapi.model.entity.Post;
import com.blogapi.repository.CategoryRepository;
import com.blogapi.repository.PostRepository;
import com.blogapi.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private PostService postService;

    private Category category;
    private Post post;
    private PostRequest postRequest;

    @BeforeEach
    void setUp() {
        category = Category.builder()
                .id(1L)
                .name("Technology")
                .description("Tech articles")
                .build();

        post = Post.builder()
                .id(1L)
                .title("Test Post")
                .content("Test Content")
                .author("Test Author")
                .category(category)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        postRequest = PostRequest.builder()
                .title("Test Post")
                .content("Test Content")
                .author("Test Author")
                .categoryId(1L)
                .build();
    }

    @Test
    void getPostById_ShouldReturnPost_WhenPostExists() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        PostResponse response = postService.getPostById(1L);

        assertNotNull(response);
        assertEquals("Test Post", response.getTitle());
        assertEquals("Test Author", response.getAuthor());
        verify(postRepository, times(1)).findById(1L);
    }

    @Test
    void getPostById_ShouldThrowException_WhenPostNotFound() {
        when(postRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> postService.getPostById(99L));
    }

    @Test
    void createPost_ShouldCreateAndReturnPost() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(postRepository.save(any(Post.class))).thenReturn(post);

        PostResponse response = postService.createPost(postRequest);

        assertNotNull(response);
        assertEquals("Test Post", response.getTitle());
        verify(postRepository, times(1)).save(any(Post.class));
    }

    @Test
    void deletePost_ShouldDelete_WhenPostExists() {
        when(postRepository.existsById(1L)).thenReturn(true);
        doNothing().when(postRepository).deleteById(1L);

        assertDoesNotThrow(() -> postService.deletePost(1L));
        verify(postRepository, times(1)).deleteById(1L);
    }

    @Test
    void deletePost_ShouldThrowException_WhenPostNotFound() {
        when(postRepository.existsById(99L)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> postService.deletePost(99L));
    }
}
