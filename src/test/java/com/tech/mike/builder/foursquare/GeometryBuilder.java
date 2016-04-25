package com.tech.mike.builder.foursquare;

import com.tech.mike.client.foursquare.dto.Bounds;
import com.tech.mike.client.foursquare.dto.Geometry;
import com.tech.mike.client.foursquare.dto.Location;

public class GeometryBuilder {
    private Location centre = new LocationBuilder().build();
    private Bounds bounds = new BoundsBuilder().build();

    public GeometryBuilder withCentre(Location centre) {
        this.centre = centre;
        return this;
    }

    public GeometryBuilder withBounds(Bounds bounds) {
        this.bounds = bounds;
        return this;
    }

    public Geometry build() {
        Geometry geometry = new Geometry(
                this.centre,
                this.bounds
        );
        return geometry;
    }
}
