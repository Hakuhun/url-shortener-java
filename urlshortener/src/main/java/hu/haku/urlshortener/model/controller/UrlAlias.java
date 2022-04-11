package hu.haku.urlshortener.model.controller;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import hu.haku.urlshortener.model.controller.Report;
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
 * UrlAlias
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-11T01:28:37.736+02:00[Europe/Prague]")
public class UrlAlias   {

  @JsonProperty("id")
  private String id;

  @JsonProperty("originalUrl")
  private String originalUrl;

  @JsonProperty("requestedAlias")
  private String requestedAlias;

  @JsonProperty("report")
  private Report report;

  @JsonProperty("requester")
  private Requester requester;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    READY("READY"),
    
    COMPROMISED("COMPROMISED"),
    
    DELETED("DELETED");

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

  public UrlAlias id(String id) {
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

  public UrlAlias originalUrl(String originalUrl) {
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

  public UrlAlias requestedAlias(String requestedAlias) {
    this.requestedAlias = requestedAlias;
    return this;
  }

  /**
   * Get requestedAlias
   * @return requestedAlias
  */
  
  @Schema(name = "requestedAlias", required = false)
  public String getRequestedAlias() {
    return requestedAlias;
  }

  public void setRequestedAlias(String requestedAlias) {
    this.requestedAlias = requestedAlias;
  }

  public UrlAlias report(Report report) {
    this.report = report;
    return this;
  }

  /**
   * Get report
   * @return report
  */
  @Valid 
  @Schema(name = "report", required = false)
  public Report getReport() {
    return report;
  }

  public void setReport(Report report) {
    this.report = report;
  }

  public UrlAlias requester(Requester requester) {
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

  public UrlAlias status(StatusEnum status) {
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

  public UrlAlias creationDate(LocalDate creationDate) {
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
    UrlAlias urlAlias = (UrlAlias) o;
    return Objects.equals(this.id, urlAlias.id) &&
        Objects.equals(this.originalUrl, urlAlias.originalUrl) &&
        Objects.equals(this.requestedAlias, urlAlias.requestedAlias) &&
        Objects.equals(this.report, urlAlias.report) &&
        Objects.equals(this.requester, urlAlias.requester) &&
        Objects.equals(this.status, urlAlias.status) &&
        Objects.equals(this.creationDate, urlAlias.creationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, originalUrl, requestedAlias, report, requester, status, creationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UrlAlias {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    originalUrl: ").append(toIndentedString(originalUrl)).append("\n");
    sb.append("    requestedAlias: ").append(toIndentedString(requestedAlias)).append("\n");
    sb.append("    report: ").append(toIndentedString(report)).append("\n");
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

