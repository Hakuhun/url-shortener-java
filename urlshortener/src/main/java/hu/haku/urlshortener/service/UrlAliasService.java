package hu.haku.urlshortener.service;

import hu.haku.urlshortener.model.business.BDReport;
import hu.haku.urlshortener.model.business.BDUrlAlias;
import hu.haku.urlshortener.persistence.repositories.UrlShortDAO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlAliasService {
    private final UrlShortDAO dao;

    /**
     * Creates a new {class="{@link hu.haku.urlshortener.persistence.model.MDBUrlAlias"}"} element.
     * If a requestedAlias is provided and it is not in use yet it will save the entity with the requested alias.
     * In other cases a brand new alias is generated for the original url.
     * For an original url there must be a unique alias for every time it has been asked.
     *
     * @param urlAlias
     * @return A saved alias entity
     */
    public BDUrlAlias addShortening(BDUrlAlias urlAlias) {

        if (StringUtils.isBlank(urlAlias.getRequestedAlias())) {
            urlAlias.setRequestedAlias(new ObjectId().toHexString());
        }
        urlAlias.setStatus(BDUrlAlias.BDStatus.READY);

        if (dao.existsByRequestedAlias(urlAlias.getRequestedAlias())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This alias is already existing as an other shortening.");
        } else {
            //A brand new alias should be created each time an originalUrl is shortened
            return dao.save(urlAlias);
        }
    }

    public BDUrlAlias reportAlias(String alias, BDReport reason) {
        BDUrlAlias updatedAlias = dao.report(alias, reason).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such alias exists"));
        updatedAlias.setReport(Collections.singletonList(reason));
        return updatedAlias;
    }

    public String getOriginalUrl(String requestedAlias) {
        dao.increaseTimesVisit(requestedAlias);
        return dao.getOriginalByRequestAlias(requestedAlias)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such resource exists")).getOriginalUrl();
    }
}
