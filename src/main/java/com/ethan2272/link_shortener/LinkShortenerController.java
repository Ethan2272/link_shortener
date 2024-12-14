package com.ethan2272.link_shortener;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LinkShortenerController {

    private final LinkHandlerService LHS;

    public LinkShortenerController(LinkMappingRepository LinkRepo, LinkHandlerService LSS) {
        this.LHS = LSS;
    }

    @PostMapping("/shorten")
    public LinkMapping shortenLink(@RequestParam(name="link")String link) {
        LinkMapping linkMapping = LHS.saveLink(link);
        return linkMapping;
    }

    @GetMapping("/{shortenedLink:^[^\\.]+$}")
    public ModelAndView redirectShortenedLink(@PathVariable String shortenedLink, ModelMap model) {
        String redirectLink = LHS.getOriginalLink(shortenedLink);
        return new ModelAndView("redirect:" + redirectLink, model);
    }
}
