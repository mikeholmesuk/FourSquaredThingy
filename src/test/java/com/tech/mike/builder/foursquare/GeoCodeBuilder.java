package com.tech.mike.builder.foursquare;

import com.tech.mike.client.foursquare.dto.Feature;
import com.tech.mike.client.foursquare.dto.GeoCode;

public class GeoCodeBuilder {
    private String what;
    private String where;
    private Feature feature = new FeatureBuilder().build();

    public GeoCodeBuilder withWhat(String what) {
        this.what = what;
        return this;
    }

    public GeoCodeBuilder withWhere(String where) {
        this.where = where;
        return this;
    }

    public GeoCodeBuilder withFeature(Feature feature) {
        this.feature = feature;
        return this;
    }

    public GeoCode build() {
        GeoCode geoCode = new GeoCode();
        geoCode.setWhat(this.what);
        geoCode.setWhere(this.where);
        geoCode.setFeature(this.feature);
        return geoCode;
    }
}
