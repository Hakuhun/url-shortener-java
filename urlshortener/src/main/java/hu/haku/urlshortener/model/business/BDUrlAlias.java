package hu.haku.urlshortener.model.business;

import com.fasterxml.jackson.annotation.JsonCreator;
import hu.haku.urlshortener.model.controller.UrlAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
public class BDUrlAlias {
    private String id;
    private String originalUrl;
    private String requestedAlias;
    private Instant creationDate;
    private BDRequester requester;
    private List<BDReport> report;
    private BDStatus status;

    public enum BDStatus {
        READY("READY"),

        COMPROMISED("COMPROMISED"),

        DELETED("DELETED");

        private String value;

        BDStatus(String value) {
            this.value = value;
        }

        @JsonCreator
        public static UrlAlias.StatusEnum fromValue(String value) {
            for (UrlAlias.StatusEnum b : UrlAlias.StatusEnum.values()) {
                if (b.getValue().equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }
}
