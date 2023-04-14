package com.invinity.controller;

import com.invinity.model.Post;
import com.invinity.service.PostService;
import com.invinity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping

    public ResponseEntity<List<Post>> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable(value = "id") String postId) {
        return postService.getPostById(postId);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return postService.addPost(post);
    }
}
