package hu.haku.urlshortener.controller;

import hu.haku.urlshortener.persistence.model.MDBUrlShorts;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/shortener/")
public class UrlShortenerController {

    @PostMapping("/url")
    public ResponseEntity<MDBUrlShorts> shortUrl(@RequestBody MDBUrlShorts urlShorts){
        return ResponseEntity.ok(urlShorts);
    }
}
