package hu.haku.urlshortener.controller;

import hu.haku.urlshortener.service.UrlAliasService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Log4j2
@RestController
@RequestMapping("/redirect")
@RequiredArgsConstructor
public class RedirectController {
    private final UrlAliasService urlShortenerService;

    //@PutMapping("/{requestedAlias}")
    @GetMapping("/{requestedAlias}")
    public RedirectView queryUrl(@PathVariable("requestedAlias") String requestedAlias){
        String originalUrl = urlShortenerService.getOriginalUrl(requestedAlias);
        log.info("A redirect happened from "+requestedAlias + " to " + originalUrl);
        return new RedirectView(originalUrl);
    }

}
