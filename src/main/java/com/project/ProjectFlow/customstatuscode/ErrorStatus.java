package com.project.ProjectFlow.customstatuscode;

import com.project.ProjectFlow.dto.CustomStatus;

public class ErrorStatus implements CustomStatus {

    private int statusCode;
    private String statusMessage;

    public ErrorStatus() {
    }

    public ErrorStatus(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
