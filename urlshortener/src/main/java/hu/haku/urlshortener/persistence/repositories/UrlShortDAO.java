package hu.haku.urlshortener.persistence.repositories;

import hu.haku.urlshortener.converter.BDUrlAliasMDBUrlAliasConverter;
import hu.haku.urlshortener.converter.MDBUrlAliasBDUrlAliasConverter;
import hu.haku.urlshortener.model.business.BDReport;
import hu.haku.urlshortener.model.business.BDUrlAlias;
import hu.haku.urlshortener.persistence.model.MDBReport;
import hu.haku.urlshortener.persistence.model.MDBUrlAlias;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlShortDAO {
    private final UrlShortRepository repository;
    private final MongoOperations mongoOperations;
    private final MongoTemplate mongoTemplate;
    private final BDUrlAliasMDBUrlAliasConverter businessDataConverter;
    private final MDBUrlAliasBDUrlAliasConverter mongoDataConverter;

    public boolean existsByRequestedAlias(String requestedAlias) {
        return repository.existsByRequestedAlias(requestedAlias);
    }

    public boolean existsByOriginalUrl(String originalUrl) {
        return repository.existsByOriginalUrl(originalUrl);
    }

    public BDUrlAlias save(BDUrlAlias alias) {
        MDBUrlAlias dbAlias = mongoDataConverter.convert(alias);
        dbAlias.setCreationDate(Instant.now());
        dbAlias.setTimesVisited(0);
        return businessDataConverter.convert(repository.save(dbAlias));
    }

    public void increaseTimesVisit(String requestedAlias) {
        mongoOperations.updateFirst(new Query(Criteria.where(MDBUrlAlias.FIELD_REQUESTED_ALIAS).is(requestedAlias)), new Update().inc(MDBUrlAlias.FIELD_TIMES_VISITED, 1).set(MDBUrlAlias.FIELD_LAST_VISITED, Instant.now()), MDBUrlAlias.class);
    }

    public Optional<BDUrlAlias> getOriginalByRequestAlias(String requestAlias) {
        return repository.findByRequestedAlias(requestAlias).map(businessDataConverter::convert);
    }

    public Optional<BDUrlAlias> report(String alias, BDReport reason) {
        MDBReport mongoReport = MDBReport.builder()
                .reason(reason.getReason())
                .email(StringUtils.isNoneBlank(reason.getEmail()) ? reason.getEmail() : null)
                .reportTIme(Instant.now())
                .build();

        Update updateStatement = new Update()
                .push(MDBUrlAlias.FIELD_REPORTS, mongoReport)
                .set(MDBUrlAlias.FIELD_STATUS, "COMPROMISED")
                .set(MDBUrlAlias.FIELD_LAST_VISITED, Instant.now());

        Query findCriteria = new Query(Criteria.where(MDBUrlAlias.FIELD_REQUESTED_ALIAS).is(alias));

        MDBUrlAlias updatedAlias = mongoOperations.findAndModify(
                findCriteria,
                updateStatement,
                FindAndModifyOptions.options().returnNew(true),
                MDBUrlAlias.class);

        return Optional.ofNullable(businessDataConverter.convert(updatedAlias));
    }
}
