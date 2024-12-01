package com.ethan2272.link_shortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkShortenerController {

    private static final String responseTemplate = "The entered link is %s";

    @Autowired
    private LinkMappingRepository LMP;

    @GetMapping("/shorten")
    public LinkMapping shortenLink(@RequestParam(name="link")String link) {
        LinkMapping linkMapping = new LinkMapping(link);
        LMP.save(linkMapping);
        return linkMapping;
    }
}
