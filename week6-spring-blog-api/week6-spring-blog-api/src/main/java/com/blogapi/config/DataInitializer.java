package com.blogapi.config;

import com.blogapi.model.entity.Category;
import com.blogapi.model.entity.Comment;
import com.blogapi.model.entity.Post;
import com.blogapi.repository.CategoryRepository;
import com.blogapi.repository.CommentRepository;
import com.blogapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    @Bean
    @Profile("dev")
    public CommandLineRunner loadSampleData(
            CategoryRepository categoryRepository,
            PostRepository postRepository,
            CommentRepository commentRepository) {

        return args -> {
            log.info("Loading sample data...");

            // Categories
            Category tech = categoryRepository.save(Category.builder()
                    .name("Technology").description("Tech news and updates").build());
            Category prog = categoryRepository.save(Category.builder()
                    .name("Programming").description("Programming tutorials and tips").build());
            Category web = categoryRepository.save(Category.builder()
                    .name("Web Development").description("Web dev articles and guides").build());

            // Posts
            Post p1 = postRepository.save(Post.builder()
                    .title("Getting Started with Spring Boot")
                    .content("Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.")
                    .author("John Doe")
                    .category(tech)
                    .build());

            Post p2 = postRepository.save(Post.builder()
                    .title("Java 17 New Features")
                    .content("Java 17 is a long-term support (LTS) release. Let's explore its new features.")
                    .author("Jane Smith")
                    .category(prog)
                    .build());

            Post p3 = postRepository.save(Post.builder()
                    .title("REST API Best Practices")
                    .content("Building RESTful APIs with proper conventions and best practices.")
                    .author("Bob Johnson")
                    .category(web)
                    .build());

            Post p4 = postRepository.save(Post.builder()
                    .title("Spring Data JPA Guide")
                    .content("A comprehensive guide to Spring Data JPA, repositories, and Hibernate.")
                    .author("Alice Brown")
                    .category(prog)
                    .build());

            Post p5 = postRepository.save(Post.builder()
                    .title("Microservices with Spring Cloud")
                    .content("Learn how to build microservices architecture with Spring Cloud and Netflix OSS.")
                    .author("Charlie Davis")
                    .category(tech)
                    .build());

            // Comments
            commentRepository.save(Comment.builder()
                    .content("Great article! Very helpful for beginners.").author("Reader1").post(p1).build());
            commentRepository.save(Comment.builder()
                    .content("Thanks for sharing! I learned a lot.").author("Reader2").post(p1).build());
            commentRepository.save(Comment.builder()
                    .content("Java 17 is amazing! The sealed classes feature is my favorite.").author("DevGuru").post(p2).build());
            commentRepository.save(Comment.builder()
                    .content("Clear and concise. Bookmarked!").author("WebDev123").post(p3).build());

            log.info("Sample data loaded: 3 categories, 5 posts, 4 comments.");
        };
    }
}
