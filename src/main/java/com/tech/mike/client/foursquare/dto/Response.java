package com.tech.mike.client.foursquare.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    @NotNull
    private List<Venue> venues;
    @NotNull
    private List<Category> categories;

    public List<Venue> getVenues() {
        return venues;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
