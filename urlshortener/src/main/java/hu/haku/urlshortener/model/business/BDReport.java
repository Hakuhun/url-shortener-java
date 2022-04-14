package hu.haku.urlshortener.model.business;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class BDReport {
    private String email;
    private String reason;
    private Instant reportTIme;
}
