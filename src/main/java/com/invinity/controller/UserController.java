package com.invinity.controller;

import com.invinity.model.Post;
import com.invinity.model.User;
import com.invinity.service.PostService;
import com.invinity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @GetMapping

    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable(value = "id") String userId) {
       return userService.getUserById(userId);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<Optional<List<Post>>> getUserPosts (@PathVariable(value = "id") String id) {
        return postService.getPostsByWriterId(id);
    }
}
