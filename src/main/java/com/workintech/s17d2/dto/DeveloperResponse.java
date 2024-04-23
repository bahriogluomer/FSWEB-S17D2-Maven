package com.workintech.s17d2.dto;
import com.workintech.s17d2.model.Developer;

public class DeveloperResponse {

    private Developer developer;
    private String message;
    private Integer status;

    public DeveloperResponse(Developer developer, String message, Integer status) {
        this.developer = developer;
        this.message = message;
        this.status = status;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
