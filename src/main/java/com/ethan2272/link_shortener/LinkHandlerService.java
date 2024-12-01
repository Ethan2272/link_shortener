package com.ethan2272.link_shortener;

import org.springframework.stereotype.Service;

@Service
public class LinkHandlerService {
    private LinkMappingRepository LinkRepo;

    public LinkHandlerService(LinkMappingRepository LinkRepo) {
        this.LinkRepo = LinkRepo;
    }

    public LinkMapping shortenAndSaveLink(String originalLink) {
        LinkMapping linkMapping = new LinkMapping("shortlink", originalLink);
        LinkRepo.save(linkMapping);
        return linkMapping;
    }

    public String getOriginalLink(String shortenedLink) {
        LinkMapping linkMapping = LinkRepo.getReferenceById(shortenedLink);
        return linkMapping.getOriginalLink();
    }
}
