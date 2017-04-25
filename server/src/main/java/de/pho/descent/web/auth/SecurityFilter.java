package de.pho.descent.web.auth;

import static de.pho.descent.shared.auth.ParamValue.*;
import de.pho.descent.shared.auth.SecurityTools;
import de.pho.descent.shared.exception.ErrorMessage;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author pho
 */
@Provider
public class SecurityFilter implements ContainerRequestFilter {

    private static final Logger LOG = Logger.getLogger(SecurityFilter.class.getName());

    @Inject
    private PlayerController playerController;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (requestContext.getUriInfo().getPath().contains(SECURED_URL)) {
            List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
            if (authHeader != null && authHeader.size() > 0) {
                String[] authData = SecurityTools.extractDataFromAuthHeaderValue(authHeader.get(0));
                String decodedUser = authData[0];
                String digestHash = authData[1];
                String uriPath = requestContext.getUriInfo().getRequestUri().getPath();

                try {
                    if (playerController.doAuthenticate(decodedUser, requestContext.getMethod(), uriPath, digestHash)) {
                        return;
                    }
                } catch (UserValidationException ex) {
                    LOG.log(Level.SEVERE, ex.getMessage(), ex);
                }

            }
            Response unauthorizedStatus = Response
                    .status(Response.Status.UNAUTHORIZED)
                    .type(MediaType.APPLICATION_JSON)
                    .entity(new ErrorMessage("Access not allowed", Response.Status.UNAUTHORIZED.getStatusCode()))
                    .build();

            requestContext.abortWith(unauthorizedStatus);
        }

    }

}