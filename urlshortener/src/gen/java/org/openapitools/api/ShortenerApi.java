package org.openapitools.api;

import hu.haku.urlshortener.model.controller.*;
import org.openapitools.api.ShortenerApiService;
import org.openapitools.api.factories.ShortenerApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import hu.haku.urlshortener.model.controller.UrlShorts;

import java.util.Map;
import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/shortener/url")


@io.swagger.annotations.Api(description = "the shortener API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2022-04-08T02:16:08.730+02:00[Europe/Prague]")
public class ShortenerApi  {
   private final ShortenerApiService delegate;

   public ShortenerApi(@Context ServletConfig servletContext) {
      ShortenerApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("ShortenerApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (ShortenerApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         }
      }

      if (delegate == null) {
         delegate = ShortenerApiServiceFactory.getShortenerApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json", "application/xml" })
    
    @io.swagger.annotations.ApiOperation(value = "Add a new url to redirect to a page with a shorter alias", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "api_key")
    }, tags={ "url", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 201, message = "A new alias has been created", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class)
    })
    public Response addShortenedUrl(@ApiParam(value = "An object what represents a shortened alias.", required = true) @NotNull @Valid  UrlShorts urlShorts,@ApiParam(value = "" )@HeaderParam("apiKey") String apiKey,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addShortenedUrl(urlShorts, apiKey, securityContext);
    }
}
