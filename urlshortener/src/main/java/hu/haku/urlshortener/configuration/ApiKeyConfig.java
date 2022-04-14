package hu.haku.urlshortener.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "api")
@Data
public class ApiKeyConfig {
    private Map<String, ApiKeySettings> keys;

    @Data
    private static class ApiKeySettings {
        private List<String> accessTo;
    }

    public boolean isConsumerAllowedToUse(String consumerApiKey, String endpoint) {
        return isExists(consumerApiKey) && (isConsumerAllAccess(consumerApiKey) || keys.get(consumerApiKey).getAccessTo().contains(endpoint));
    }

    private boolean isConsumerAllAccess(String consumerApiKey) {
        return keys.get(consumerApiKey).getAccessTo().contains("*");
    }

    private boolean isExists(String consumerApiKey) {
        return !CollectionUtils.isEmpty(keys) && keys.get(consumerApiKey) != null;
    }
}
