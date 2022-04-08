package hu.haku.urlshortener.persistence.repositories;

import hu.haku.urlshortener.persistence.model.MDBUrlShorts;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlShortRepository extends MongoRepository<MDBUrlShorts, ObjectId> {
}
