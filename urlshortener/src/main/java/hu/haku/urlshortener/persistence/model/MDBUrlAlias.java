package hu.haku.urlshortener.persistence.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;

@Data
@Document("urlAlias")
public class MDBUrlAlias {
    public static final String FIELD_REQUESTED_ALIAS = "requestedAlias";
    public static final String FIELD_TIMES_VISITED = "timesVisited";
    public static final String FIELD_LAST_VISITED = "lastVisited";
    public static final String FIELD_REPORTS = "reports";
    public static final String FIELD_STATUS = "status";

    @Id
    private ObjectId _id;
    @Indexed
    private String originalUrl;
    @Indexed
    private String requestedAlias;
    private Instant creationDate;
    private Instant lastVisited;
    private MDBRequester requester;
    private List<MDBReport> reports;
    private String status;
    private long timesVisited;
}
