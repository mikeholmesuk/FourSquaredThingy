package com.tech.mike.builder.foursquare;

import com.tech.mike.client.foursquare.dto.Location;
import uk.org.fyodor.generators.RDG;
import uk.org.fyodor.range.Range;

public class LocationBuilder {
    private Double longitude = RDG.doubleVal(Range.closed(-90.0, 90.0)).next();
    private Double latitude = RDG.doubleVal(Range.closed(-90.0, 90.0)).next();

    public LocationBuilder withLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public LocationBuilder withLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public LocationBuilder withLongAndLat(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        return this;
    }

    public Location build() {
        Location location = new Location();
        location.setLongitude(this.longitude);
        location.setLatitude(this.latitude);
        return location;
    }
}
