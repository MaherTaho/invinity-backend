package com.invinity.service;

import com.invinity.model.Post;
import com.invinity.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok().body(postRepository.findAll());
    }

    public ResponseEntity<Optional<Post>> getPostById(String postId) {
        if(postExist(postId))
            return ResponseEntity.ok().body(postRepository.findById(postId));
        return ResponseEntity.status(404).body(null);
    }
    public boolean postExist(String postId) {
        return postRepository.findById(postId).isPresent();
    }
    public ResponseEntity<Post> addPost(Post post) {
        if(postExist(post.getId()))
            return ResponseEntity.status(409).body(null);
        post.setCreatedAt(System.currentTimeMillis());
        return ResponseEntity.ok().body(postRepository.save(post));
    }

    public ResponseEntity<Optional<List<Post>>> getPostsByWriterId (String writerId) {
        if(userService.userExist(writerId))
            return ResponseEntity.ok().body(postRepository.findByWriterId(writerId));
        return ResponseEntity.status(404).body(null);
    }
}
