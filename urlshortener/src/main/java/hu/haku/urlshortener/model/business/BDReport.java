package hu.haku.urlshortener.model.business;

import lombok.Data;

import java.time.Instant;

@Data
public class BDReport {
    private String email;
    private String reason;
    private Instant reportTIme;
}
