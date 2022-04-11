package hu.haku.urlshortener.persistence.repositories;

import hu.haku.urlshortener.persistence.model.MDBUrlAlias;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UrlShortRepository extends MongoRepository<MDBUrlAlias, ObjectId> {

    public boolean existsByRequestedAlias(String requestedAlias);
    public boolean existsByOriginalUrl(String originalUrl);
    public Optional<MDBUrlAlias> findByRequestedAlias(String requestedAlias);

}
