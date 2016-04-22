package com.tech.mike.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class What3WordsConfiguration {
    @NotNull
    @JsonProperty(value = "host_url")
    private String hostUrl;

    @NotNull
    @JsonProperty(value = "api_key")
    private String apiKey;

    public String getHostUrl() {
        return hostUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}
