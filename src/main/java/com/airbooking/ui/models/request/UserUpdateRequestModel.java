package com.airbooking.ui.models.request;

import javax.validation.constraints.NotNull;

public class UserUpdateRequestModel {
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
