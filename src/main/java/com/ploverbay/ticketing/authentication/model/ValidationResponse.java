package com.ploverbay.ticketing.authentication.model;

import java.util.List;

/**
 * Describe this class
 *
 * @author Keno San Pedro
 *
 */
public class ValidationResponse {

    private String m_status;
    private List<ErrorMessage> m_errorMessageList;

    public String getStatus() {
        return m_status;
    }

    public void setStatus(String status) {
        m_status = status;
    }

    public List<ErrorMessage> getErrorMessageList() {
        return m_errorMessageList;
    }

    public void setErrorMessageList(List<ErrorMessage> errorMessageList) {
        m_errorMessageList = errorMessageList;
    }
}
