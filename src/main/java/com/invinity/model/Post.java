package com.invinity.model;

import lombok.Data;
import lombok.Generated;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("posts")
@Data
public class Post {
    @Id
    @Generated
    private String id;
    @NonNull
    private String writerId;
    @NonNull
    private String content;
    private String[] images;

    private long createdAt;
}
