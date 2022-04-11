package hu.haku.urlshortener.persistence.model;

import lombok.Data;

@Data
public class MDBRequester {
    private String email;
    private String ipAddress;
}
