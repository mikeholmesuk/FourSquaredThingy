package com.tech.mike.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class FourSquareConfiguration {
    @NotNull
    @JsonProperty(value = "host_url")
    private String hostUrl;

    @NotNull
    @JsonProperty(value = "client_id")
    private String clientId;

    @NotNull
    @JsonProperty(value = "client_secret")
    private String clientSecret;

    @NotNull
    @JsonProperty(value = "api_version")
    private String apiVersion;

    public String getHostUrl() {
        return hostUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getApiVersion() {
        return apiVersion;
    }
}
