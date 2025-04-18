package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// PostService.java
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() { return postRepository.findAll(); }

    public Optional<Post> getPostById(Long id) { return postRepository.findById(id); }

    public Post createPost(Post post) { return postRepository.save(post); }

    public void deletePost(Long id) { postRepository.deleteById(id); }


    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));

        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());

        // Only update user if provided in the request
        if (postDetails.getUser() != null && postDetails.getUser().getId() != null) {
            post.setUser(postDetails.getUser());
        }

        return postRepository.save(post);
    }
}

