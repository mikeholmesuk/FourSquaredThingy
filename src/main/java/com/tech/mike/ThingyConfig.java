package com.tech.mike;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.mike.config.FourSquareConfiguration;
import com.tech.mike.config.What3WordsConfiguration;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

public class ThingyConfig extends Configuration {
    @NotNull
    @JsonProperty(value = "4square")
    private FourSquareConfiguration fourSquareConfig;

    @NotNull
    @JsonProperty(value = "what3words")
    private What3WordsConfiguration w3wConfig;

    public FourSquareConfiguration getFourSquareConfig() {
        return fourSquareConfig;
    }

    public What3WordsConfiguration getW3wConfig() {
        return this.w3wConfig;
    }
}
