package com.tech.mike.builder;

import com.tech.mike.representation.GeoLocation;
import uk.org.fyodor.generators.RDG;
import uk.org.fyodor.range.Range;

public class GeoLocationBuilder {
    private Double longitude = RDG.doubleVal(Range.closed(-90.0, 90.0)).next();
    private Double latitude = RDG.doubleVal(Range.closed(-90.0, 90.0)).next();

    public GeoLocationBuilder withLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public GeoLocationBuilder withLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public GeoLocationBuilder withLongAndLat(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        return this;
    }

    public GeoLocation build() {
        GeoLocation geoLocation = new GeoLocation(
                this.longitude,
                this.latitude
        );

        return geoLocation;
    }
}
