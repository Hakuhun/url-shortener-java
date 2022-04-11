package hu.haku.urlshortener.validator;

import hu.haku.urlshortener.model.controller.UrlAlias;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UrlShortenerValidator {

    public void validateCreation(UrlAlias urlShort) {
        if (StringUtils.isBlank(urlShort.getOriginalUrl())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "urlAlias.originalUrl is a mandatory field");
        }
    }
}
