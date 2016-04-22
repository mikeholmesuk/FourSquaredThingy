package com.tech.mike.builder.what3words;

import com.tech.mike.client.what3words.dto.Position;
import uk.org.fyodor.generators.RDG;
import uk.org.fyodor.range.Range;

import java.util.List;

public class PositionBuilder {

    private String type = RDG.string().next();
    private List<String> words = RDG.list(RDG.string(), 3).next();
    private List<Double> position = RDG.list(RDG.doubleVal(Range.closed(-90.0, 90.0)), 2).next();
    private String language = RDG.iso3Country().next();

    public PositionBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public PositionBuilder withWords(List<String> words) {
        this.words = words;
        return this;
    }

    public PositionBuilder withPosition(List<Double> position) {
        this.position = position;
        return this;
    }

    public PositionBuilder withLanguage(String language) {
        this.language = language;
        return this;
    }

    // Build
    public Position build() {
        return new Position();
    }
}
