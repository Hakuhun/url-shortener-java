package org.openapitools.api;

import hu.haku.urlshortener.model.controller.*;
import org.openapitools.api.RedirectApiService;
import org.openapitools.api.factories.RedirectApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;


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

@Path("/redirect/{requestedAlias}")


@io.swagger.annotations.Api(description = "the redirect API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2022-04-08T02:16:08.730+02:00[Europe/Prague]")
public class RedirectApi  {
   private final RedirectApiService delegate;

   public RedirectApi(@Context ServletConfig servletContext) {
      RedirectApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("RedirectApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (RedirectApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         }
      }

      if (delegate == null) {
         delegate = RedirectApiServiceFactory.getRedirectApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Redirects you tu the requested alias", notes = "", response = Void.class, tags={ "redirect", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 301, message = "A redirect to another page", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "Gives an error mesage caused by an unreachable resource (mo such url alias exists)", response = Void.class)
    })
    public Response redirects(@ApiParam(value = "the alias of a shortened url", required = true) @PathParam("requestedAlias") @NotNull  String requestedAlias,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.redirects(requestedAlias, securityContext);
    }
}
