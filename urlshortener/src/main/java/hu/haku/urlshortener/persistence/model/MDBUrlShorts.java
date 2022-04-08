package hu.haku.urlshortener.persistence.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.Instant;

@Data
public class MDBUrlShorts {
    @Id
    private ObjectId _id;

    private String originalUrl;
    @Indexed
    private String requestedAlias;
    private Instant creationDate;
}
