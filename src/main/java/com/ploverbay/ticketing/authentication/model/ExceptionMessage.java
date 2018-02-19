package com.ploverbay.ticketing.authentication.model;

import java.util.Date;

/**
 * Describe this class
 *
 * @author Keno San Pedro
 *
 */
public class ExceptionMessage {

    private Date m_timestamp;
    private String m_message;
    private String m_details;

    public ExceptionMessage(Date timestamp, String message, String details) {
        super();
        m_timestamp = timestamp;
        m_message = message;
        m_details = details;
    }

    public String getDetails() {
        return m_details;
    }

    public String getMessage() {
        return m_message;
    }

    public Date getTimestamp() {
        return m_timestamp;
    }

    public void setDetails(String details) {
        m_details = details;
    }

    public void setMessage(String message) {
        m_message = message;
    }

    public void setTimestamp(Date timestamp) {
        m_timestamp = timestamp;
    }

}
