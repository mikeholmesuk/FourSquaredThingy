package com.tech.mike.client.foursquare.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    @NotNull(message = "Latitude cannot be NULL")
    @Min(value = -90, message = "Latitude value must be a minimum of -90°")
    @Max(value = 90, message = "Latitude value must be a maximum of 90°")
    @JsonProperty(value = "lat")
    private Double latitude;

    @NotNull(message = "Longitude cannot be NULL")
    @Min(value = -90, message = "Longitude value must be a minimum of -90°")
    @Max(value = 90, message = "Longitude value must be a maximum of 90°")
    @JsonProperty(value = "lng")
    private Double longitude;

    @JsonProperty(value = "address")
    private String address;
    @JsonProperty(value = "city")
    private String city;
    @JsonProperty(value = "postalCode")
    private String postalCode;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
