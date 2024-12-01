package com.ethan2272.link_shortener;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LinkMapping {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String originalLink;

    public LinkMapping(String originalLink) {
        this.originalLink = originalLink;
    }

    public Long getId() {
        return id;
    }

    public String getOriginalLink() {
        return originalLink;
    }
}