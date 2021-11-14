/*
 * Copyright Ashis Raj
 */

package com.araj.cucumber.elasticsearch.json.pojo;

import com.araj.cucumber.elasticsearch.utils.CucElasticPluginUtils;

import java.util.Objects;

public class Tag {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getUrlFriendlyName() {
        return CucElasticPluginUtils.escapeHTML(name).replace("@", "");
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.araj.cucumber.elasticsearch.json.pojo.Tag tag = (com.araj.cucumber.elasticsearch.json.pojo.Tag) o;
        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
