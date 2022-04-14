package hu.haku.urlshortener.persistence.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class MDBReport {
    private String email;
    private String reason;
    private Instant reportTIme;
}
