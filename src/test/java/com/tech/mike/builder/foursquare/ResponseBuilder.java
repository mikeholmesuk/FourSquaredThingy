package com.tech.mike.builder.foursquare;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.mike.client.foursquare.dto.Category;
import com.tech.mike.client.foursquare.dto.GeoCode;
import com.tech.mike.client.foursquare.dto.Response;
import com.tech.mike.client.foursquare.dto.Venue;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ResponseBuilder {
    private List<Venue> venues = new ArrayList<Venue>();
    private List<Category> categories = new ArrayList<Category>();
    private GeoCode geoCode = new GeoCodeBuilder().build();

    public ResponseBuilder withVenues(List<Venue> venues) {
        this.venues = venues;
        return this;
    }

    public ResponseBuilder withAddedVenue(Venue venue) {
        this.venues.add(venue);
        return this;
    }

    public ResponseBuilder withCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public ResponseBuilder withAddedCategory(Category category) {
        this.categories.add(category);
        return this;
    }

    public ResponseBuilder withGeoCode(GeoCode geoCode) {
        this.geoCode = geoCode;
        return this;
    }

    public Response build() {
        Response response = new Response();
        response.setCategories(this.categories);
        response.setVenues(this.venues);
        response.setGeoCode(this.geoCode);
        return response;
    }
}
