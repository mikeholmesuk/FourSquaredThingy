package com.tech.mike.builder.foursquare;

import com.tech.mike.client.foursquare.dto.Bounds;
import com.tech.mike.client.foursquare.dto.Location;

public class BoundsBuilder {
    private Location northEastCorner = new LocationBuilder().build();
    private Location southWestCorner = new LocationBuilder().build();

    public BoundsBuilder withNorthEastCorner(Location northEastCorner) {
        this.northEastCorner = northEastCorner;
        return this;
    }

    public BoundsBuilder withSouthWestCorner(Location southWestCorner) {
        this.southWestCorner = southWestCorner;
        return this;
    }

    public Bounds build() {
        Bounds bounds = new Bounds(
                this.northEastCorner,
                this.southWestCorner
        );
        return bounds;
    }
}
