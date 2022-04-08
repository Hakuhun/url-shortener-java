package hu.haku.urlshortener.model.controller;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import hu.haku.urlshortener.model.controller.Requester;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UrlShorts
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-08T02:33:27.185+02:00[Europe/Prague]")
public class UrlShorts   {

  @JsonProperty("id")
  private String id;

  @JsonProperty("originalUrl")
  private String originalUrl;

  @JsonProperty("requestedUrl")
  private String requestedUrl;

  @JsonProperty("requester")
  private Requester requester;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    READY("READY"),
    
    COMPROMISED("COMPROMISED"),
    
    NOT_EXISTS("NOT_EXISTS");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("status")
  private StatusEnum status;

  @JsonProperty("creationDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate creationDate;

  public UrlShorts id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UrlShorts originalUrl(String originalUrl) {
    this.originalUrl = originalUrl;
    return this;
  }

  /**
   * Get originalUrl
   * @return originalUrl
  */
  @NotNull 
  @Schema(name = "originalUrl", required = true)
  public String getOriginalUrl() {
    return originalUrl;
  }

  public void setOriginalUrl(String originalUrl) {
    this.originalUrl = originalUrl;
  }

  public UrlShorts requestedUrl(String requestedUrl) {
    this.requestedUrl = requestedUrl;
    return this;
  }

  /**
   * Get requestedUrl
   * @return requestedUrl
  */
  
  @Schema(name = "requestedUrl", required = false)
  public String getRequestedUrl() {
    return requestedUrl;
  }

  public void setRequestedUrl(String requestedUrl) {
    this.requestedUrl = requestedUrl;
  }

  public UrlShorts requester(Requester requester) {
    this.requester = requester;
    return this;
  }

  /**
   * Get requester
   * @return requester
  */
  @Valid 
  @Schema(name = "requester", required = false)
  public Requester getRequester() {
    return requester;
  }

  public void setRequester(Requester requester) {
    this.requester = requester;
  }

  public UrlShorts status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", required = false)
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public UrlShorts creationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Get creationDate
   * @return creationDate
  */
  @Valid 
  @Schema(name = "creationDate", required = false)
  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UrlShorts urlShorts = (UrlShorts) o;
    return Objects.equals(this.id, urlShorts.id) &&
        Objects.equals(this.originalUrl, urlShorts.originalUrl) &&
        Objects.equals(this.requestedUrl, urlShorts.requestedUrl) &&
        Objects.equals(this.requester, urlShorts.requester) &&
        Objects.equals(this.status, urlShorts.status) &&
        Objects.equals(this.creationDate, urlShorts.creationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, originalUrl, requestedUrl, requester, status, creationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UrlShorts {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    originalUrl: ").append(toIndentedString(originalUrl)).append("\n");
    sb.append("    requestedUrl: ").append(toIndentedString(requestedUrl)).append("\n");
    sb.append("    requester: ").append(toIndentedString(requester)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

