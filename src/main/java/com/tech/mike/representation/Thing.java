package com.tech.mike.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Thing {
    @NotNull(message = "Display name cannot be null")
    @JsonProperty(value = "display_name")
    private String displayName;
    @JsonProperty(value = "geo_location")
    private GeoLocation geoLocation;
    @JsonProperty(value = "thingies")
    private List<Thingy> thingies;

    public Thing() {}

    public Thing(String displayName, GeoLocation geoLocation, List<Thingy> thingies) {
        this.displayName = displayName;
        this.geoLocation = geoLocation;
        this.thingies = thingies;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public void setThingies(List<Thingy> thingies) {
        this.thingies = thingies;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<Thingy> getThingies() {
        return thingies;
    }
}
