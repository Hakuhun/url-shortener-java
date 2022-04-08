package org.openapitools.api;

import org.openapitools.api.*;
import hu.haku.urlshortener.model.controller.*;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;

import hu.haku.urlshortener.model.controller.UrlShorts;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2022-04-08T02:16:08.730+02:00[Europe/Prague]")
public abstract class ShortenerApiService {
    public abstract Response addShortenedUrl(UrlShorts urlShorts,String apiKey,SecurityContext securityContext) throws NotFoundException;
}
