package com.ethan2272.link_shortener;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LinkMapping {
    @Id
    private String shortLink;
    private String originalLink;

    public LinkMapping() { }

    public LinkMapping(String shortLink, String originalLink) {
        this.shortLink = shortLink;
        this.originalLink = originalLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public String getShortLink() {
        return shortLink;
    }

    public String getOriginalLink() {
        return originalLink;
    }
}