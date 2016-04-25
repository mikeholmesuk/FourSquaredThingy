package com.tech.mike.builder.foursquare;

import com.tech.mike.client.foursquare.dto.Feature;
import com.tech.mike.client.foursquare.dto.Geometry;
import uk.org.fyodor.generators.RDG;

public class FeatureBuilder {
    private String countryCode = RDG.iso3Country().next();
    private String name = RDG.string().next();
    private String displayName = RDG.string().next();
    private Geometry geometry = new GeometryBuilder().build();

    public FeatureBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public FeatureBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public FeatureBuilder withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public FeatureBuilder withGeometry(Geometry geometry) {
        this.geometry = geometry;
        return this;
    }

    public Feature build() {
        Feature feature = new Feature();
        feature.setCountryCode(this.countryCode);
        feature.setName(this.name);
        feature.setDisplayName(this.displayName);
        feature.setGeometry(this.geometry);
        return feature;
    }
}
