package com.ploverbay.ticketing.authentication.model;


/**
 * Describe this class
 *
 * @author Keno San Pedro
 *
 */
public class ErrorMessage {

    private String m_fieldName;
    private String m_message;

    public String getFieldName() {
        return m_fieldName;
    }
    public void setFieldName(String fieldName) {
        m_fieldName = fieldName;
    }
    public String getMessage() {
        return m_message;
    }
    public void setMessage(String message) {
        m_message = message;
    }

    public ErrorMessage(String fieldName, String message) {
        m_fieldName = fieldName;
        m_message = message;
    }

}