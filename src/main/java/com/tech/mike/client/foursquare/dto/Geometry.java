package com.tech.mike.client.foursquare.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {
    @JsonProperty(value = "center")
    private Location centre;    // Correcting the spelling
    @JsonProperty(value = "bounds")
    private Bounds bounds;

    public Geometry() {}

    public Geometry(Location centre, Bounds bounds) {
        this.centre = centre;
        this.bounds = bounds;
    }

    public Location getCentre() {
        return centre;
    }

    public Bounds getBounds() {
        return bounds;
    }
}
