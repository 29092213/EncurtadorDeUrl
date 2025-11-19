package com.encurtadorUrl.Encurtador.ENTITY;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "URL-REDUCE")
public class UrlEntity {

    @Id
    private String id;

    private String fullUrl;
    private String reduceUrl;

    @Indexed(expireAfterSeconds = 120)
    private LocalDateTime expireAt;

    public UrlEntity(String id, String fullUrl, String reduceUrl, LocalDateTime expireAt) {
        this.id = id;
        this.fullUrl = fullUrl;
        this.reduceUrl = reduceUrl;
        this.expireAt = expireAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getReduceUrl() {
        return reduceUrl;
    }

    public void setReduceUrl(String reduceUrl) {
        this.reduceUrl = reduceUrl;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }
}
