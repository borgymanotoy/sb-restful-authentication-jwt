package com.ploverbay.ticketing.authentication.exception;

import org.apache.commons.lang.exception.NestableException;

/**
 * Describe this class
 *
 * @author Keno San Pedro
 *
 */
public class ObjectNotFoundException extends NestableException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String debugMessage) {
        super(debugMessage);
    }

}
