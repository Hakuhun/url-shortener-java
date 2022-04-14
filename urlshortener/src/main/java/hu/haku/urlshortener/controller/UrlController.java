package hu.haku.urlshortener.controller;

import hu.haku.urlshortener.configuration.framework.ApiKeyChecker;
import hu.haku.urlshortener.converter.BDUrlAliasUrlAliasConverter;
import hu.haku.urlshortener.converter.UrlAliasBDUrlAliasConverter;
import hu.haku.urlshortener.model.business.BDReport;
import hu.haku.urlshortener.model.controller.UrlAlias;
import hu.haku.urlshortener.service.UrlAliasService;
import hu.haku.urlshortener.validator.UrlShortenerValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Log4j2
@RestController
@RequestMapping("/url/")
@RequiredArgsConstructor
public class UrlController {

    private final UrlAliasService urlShortenerService;
    private final UrlAliasBDUrlAliasConverter interfaceToBusinessConverter;
    private final BDUrlAliasUrlAliasConverter businessToInterfaceConverter;
    private final UrlShortenerValidator validator;

    @ApiKeyChecker(endpointName = "shorten")
    @PostMapping("/shorten")
    public ResponseEntity<UrlAlias> shortUrl(
            @RequestBody UrlAlias urlShorts,
            @RequestHeader("X-Forwarded-For") String ipAddress
    ) {
        validator.validateCreation(urlShorts);
        return ResponseEntity.ok(businessToInterfaceConverter.convert(urlShortenerService.addShortening(interfaceToBusinessConverter.convert(urlShorts, ipAddress))));
    }

    @ApiKeyChecker(endpointName = "report")
    @PatchMapping("/report/{requestedAlias}")
    public ResponseEntity<UrlAlias> reportUrl(
            @PathVariable("requestedAlias") String requestedAlias,
            @RequestBody UrlAlias urlShorts
    ) {
        validator.validateReport(urlShorts);
        BDReport report = Objects.requireNonNull(interfaceToBusinessConverter.convert(urlShorts)).getReport().get(0);
        return ResponseEntity.ok(
                businessToInterfaceConverter.convert(
                        urlShortenerService.reportAlias(requestedAlias, report))
        );
    }
}
