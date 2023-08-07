package com.ibm.ibmproject.controller.exceptions;

public class StandartError {

    private long timesTamp;

    private Integer status;

    private String error;

    public StandartError() {

    }

    public StandartError(long timesTamp, Integer status, String error) {
        this.timesTamp = timesTamp;
        this.status = status;
        this.error = error;
    }

    public long getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(long timesTamp) {
        this.timesTamp = timesTamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
