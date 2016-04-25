package com.tech.mike.client.foursquare.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    @JsonProperty(value = "meta")
    private Meta meta;
    @JsonProperty(value = "response")
    private Response response;

    public Result() {}

    public Result(Meta meta, Response response) {
        this.meta = meta;
        this.response = response;
    }

    public Meta getMeta() {
        return meta;
    }

    public Response getResponse() {
        return response;
    }
}
