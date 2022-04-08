/*
 * Url Shortener API definitions
 * This is a sample interface description for my demo project Url Shortener. In this project you can add urls and define a shorter url for it, let the system choose some name for it. UwU
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: hakuhun@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package hu.haku.urlshortener.model.controller;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import hu.haku.urlshortener.model.controller.Requester;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * UrlShorts
 */
@JsonPropertyOrder({
  UrlShorts.JSON_PROPERTY_ID,
  UrlShorts.JSON_PROPERTY_ORIGINAL_URL,
  UrlShorts.JSON_PROPERTY_REQUESTED_URL,
  UrlShorts.JSON_PROPERTY_REQUESTER,
  UrlShorts.JSON_PROPERTY_STATUS,
  UrlShorts.JSON_PROPERTY_CREATION_DATE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2022-04-08T02:16:08.730+02:00[Europe/Prague]")
public class UrlShorts   {
  public static final String JSON_PROPERTY_ID = "id";
  @JsonProperty(JSON_PROPERTY_ID)
  private String id;

  public static final String JSON_PROPERTY_ORIGINAL_URL = "originalUrl";
  @JsonProperty(JSON_PROPERTY_ORIGINAL_URL)
  private String originalUrl;

  public static final String JSON_PROPERTY_REQUESTED_URL = "requestedUrl";
  @JsonProperty(JSON_PROPERTY_REQUESTED_URL)
  private String requestedUrl;

  public static final String JSON_PROPERTY_REQUESTER = "requester";
  @JsonProperty(JSON_PROPERTY_REQUESTER)
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

    @Override
    @JsonValue
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

  public static final String JSON_PROPERTY_STATUS = "status";
  @JsonProperty(JSON_PROPERTY_STATUS)
  private StatusEnum status;

  public static final String JSON_PROPERTY_CREATION_DATE = "creationDate";
  @JsonProperty(JSON_PROPERTY_CREATION_DATE)
  private LocalDate creationDate;

  public UrlShorts id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @JsonProperty(value = "id")
  @ApiModelProperty(value = "")
  
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
   **/
  @JsonProperty(value = "originalUrl")
  @ApiModelProperty(required = true, value = "")
  @NotNull 
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
   **/
  @JsonProperty(value = "requestedUrl")
  @ApiModelProperty(value = "")
  
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
   **/
  @JsonProperty(value = "requester")
  @ApiModelProperty(value = "")
  @Valid 
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
   **/
  @JsonProperty(value = "status")
  @ApiModelProperty(value = "")
  
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
   **/
  @JsonProperty(value = "creationDate")
  @ApiModelProperty(value = "")
  
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
