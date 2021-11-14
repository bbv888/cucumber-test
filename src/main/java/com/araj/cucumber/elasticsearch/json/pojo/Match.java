/*
 * Copyright 2018 Ashis Raj
 */

package com.araj.cucumber.elasticsearch.json.pojo;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private String location = "";
    private List<com.araj.cucumber.elasticsearch.json.pojo.Argument> arguments = new ArrayList<>();

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public List<com.araj.cucumber.elasticsearch.json.pojo.Argument> getArguments() {
        return arguments;
    }

    public void setArguments(final List<com.araj.cucumber.elasticsearch.json.pojo.Argument> arguments) {
        this.arguments = arguments;
    }
}
