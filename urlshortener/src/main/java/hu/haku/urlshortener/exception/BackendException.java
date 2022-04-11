package hu.haku.urlshortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BackendException extends ResponseStatusException implements ResponseExceptionResult{
    public BackendException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    @Override
    public String asd() {
        return null;
    }
}
