package com.invinity.model;

import com.mongodb.lang.NonNull;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Type;

@Document("users")
@Data
public class User {
    @Id
    @Generated
    private String id;
    @NonNull
    private String username;
    @NonNull
    private String displayName;
    private long createAt;
    private String image;
    private String bio;
    private long lastSeen;
}
