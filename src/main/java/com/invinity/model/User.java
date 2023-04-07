package com.invinity.model;

import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class User {
    @Id
    private String id;
    private String username;
    private long createAt;
    private String image;
    private String bio;
    private long lastSeen;
}
