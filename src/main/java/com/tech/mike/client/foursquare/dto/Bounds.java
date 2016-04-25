package com.tech.mike.client.foursquare.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bounds {
    @JsonProperty(value = "ne")
    private Location northEastCorner;
    @JsonProperty(value = "sw")
    private Location southWestCorner;

    public Bounds () {}

    public Bounds(Location northEastCorner, Location southWestCorner) {
        this.northEastCorner = northEastCorner;
        this.southWestCorner = southWestCorner;
    }

    public Location getNorthEastCorner() {
        return northEastCorner;
    }

    public Location getSouthWestCorner() {
        return southWestCorner;
    }
}
