package hu.haku.urlshortener.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.websocket.server.PathParam;

@Log4j2
@RestController
@RequestMapping("/redirect/")
public class UrlRedirecterController {
    @PostMapping("/{requestedAlias}")
    public RedirectView queryUrl(@PathParam("requestedAlias") String requestedAlias){
        return new RedirectView(requestedAlias);
    }
}
