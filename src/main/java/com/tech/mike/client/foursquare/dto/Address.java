package com.tech.mike.client.foursquare.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address extends Location {
    @JsonProperty(value = "address")
    private String addressLine;
    @JsonProperty(value = "city")
    private String city;
    @JsonProperty(value = "postalCode")
    private String postalCode;

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
