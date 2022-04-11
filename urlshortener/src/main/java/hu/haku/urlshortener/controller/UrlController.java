package hu.haku.urlshortener.controller;

import hu.haku.urlshortener.converter.BDUrlAliasUrlAliasConverter;
import hu.haku.urlshortener.converter.UrlAliasBDUrlAliasConverter;
import hu.haku.urlshortener.model.controller.UrlAlias;
import hu.haku.urlshortener.service.UrlAliasService;
import hu.haku.urlshortener.validator.UrlShortenerValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/url/")
@RequiredArgsConstructor
public class UrlController {

    private final UrlAliasService urlShortenerService;
    private final UrlAliasBDUrlAliasConverter interfaceToBusinessConverter;
    private final BDUrlAliasUrlAliasConverter businessToInterfaceConverter;
    private final UrlShortenerValidator validator;

    @PostMapping("/shorten")
    public ResponseEntity<UrlAlias> shortUrl(
            @RequestBody UrlAlias urlShorts,
            @RequestHeader("X-Forwarded-For") String ipAddress
    ) {
        validator.validateCreation(urlShorts);
        return ResponseEntity.ok(businessToInterfaceConverter.convert(urlShortenerService.addShortening(interfaceToBusinessConverter.convert(urlShorts, ipAddress))));
    }

    @PatchMapping("/report")
    public ResponseEntity<UrlAlias> reportUrl(
            @RequestBody UrlAlias urlShorts
    ){
        throw new NotImplementedException("");
    }
}
