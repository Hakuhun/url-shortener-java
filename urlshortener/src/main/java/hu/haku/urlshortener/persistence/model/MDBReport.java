package hu.haku.urlshortener.persistence.model;

import lombok.Data;

import java.time.Instant;

@Data
public class MDBReport {
    private String email;
    private String reason;
    private Instant reportTIme;
}
