package com.ethan2272.link_shortener;

import org.springframework.stereotype.Service;

@Service
public class LinkHandlerService {
    private LinkMappingRepository LinkRepo;
    private final int KEY_LENGTH = 5;
    private final String characterSet = "abcdefghijklmnopqrstuvwxyz" +
                                        "ABCDEFGHIJKLMNOPQRESTUVWXYZ";

    public LinkHandlerService(LinkMappingRepository LinkRepo) {
        this.LinkRepo = LinkRepo;
    }

    public LinkMapping saveLink(String originalLink) {
        String shortKey;
        do {
            shortKey = generateShortKey();
        } while (LinkRepo.existsById(shortKey));

        LinkMapping linkMapping = new LinkMapping(shortKey, originalLink);
        LinkRepo.save(linkMapping);
        return linkMapping;
    }

    public String getOriginalLink(String shortenedLink) {
        LinkMapping linkMapping = LinkRepo.getReferenceById(shortenedLink);
        return linkMapping.getOriginalLink();
    }

    private String generateShortKey() {
        StringBuilder sb = new StringBuilder();
        int characterSetSize = characterSet.length();
        for(int i = 0; i < KEY_LENGTH; i++) {
            int characterIndex = (int) (Math.random() * characterSetSize);
            sb.append(characterSet.charAt(characterIndex));
        }

        return sb.toString();
    }
}
