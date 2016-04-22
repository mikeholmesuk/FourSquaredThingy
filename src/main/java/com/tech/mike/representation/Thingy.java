package com.tech.mike.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Thingy {
    @NotNull(message = "Name cannot be null")
    private String name;
    private String url;
    private String address;
    @JsonProperty(value = "post_code")
    private String postCode;
    @NotNull
    @JsonProperty(value = "geo_location")
    private GeoLocation geoLocation;

    public Thingy() {
    }

    public Thingy(String name, String url, String address, String postCode, GeoLocation geoLocation) {
        this.name = name;
        this.url = url;
        this.address = address;
        this.postCode = postCode;
        this.geoLocation = geoLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }
}
