package com.tech.mike.client.what3words.dto;

import io.dropwizard.validation.MinSize;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class Position {
    @NotNull
    private String type;

    @NotNull(message = "Words cannot be NULL")
    @Size(min = 3, max = 3, message = "Words must be a list of exactly size 3")
    private List<String> words;

    @NotNull(message = "Position cannot be NULL")
    @Size(min = 2, max = 2, message = "Position ust be a list of exactly size 2 (longitude and latitude)")
    private List<Double> position;

    @NotNull
    @Size(min = 2, max = 2)
    private String language;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public List<Double> getPosition() {
        return position;
    }

    public void setPosition(List<Double> position) {
        this.position = position;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
