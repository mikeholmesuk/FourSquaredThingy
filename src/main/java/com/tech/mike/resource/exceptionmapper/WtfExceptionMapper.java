package com.tech.mike.resource.exceptionmapper;

import com.tech.mike.exception.WtfException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WtfExceptionMapper implements ExceptionMapper<WtfException> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Response toResponse(WtfException exception) {
        logger.error("Exception caught: ", exception.getMessage());

        return Response
                .status(exception.getErrorCode() == null ? 500 : exception.getErrorCode())
                .entity(exception.getMessage())
                .build();
    }
}