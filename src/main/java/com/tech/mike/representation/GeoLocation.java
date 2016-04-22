package com.tech.mike.representation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GeoLocation {
    @NotNull
    @Size(min = -90, max = 90, message = "Longitude must be between -90 and 90")
    private Double longitude;
    @NotNull
    @Size(min = -90, max = 90, message = "Latitude must be between -90 and 90")
    private Double latitude;

    public GeoLocation() {
    }

    public GeoLocation(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
