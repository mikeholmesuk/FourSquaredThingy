package com.tech.mike.builder;

import com.tech.mike.representation.GeoLocation;
import com.tech.mike.representation.Thingy;
import com.tech.mike.representation.ThingyTest;
import uk.org.fyodor.generators.RDG;

public class ThingyBuilder {
    private String name = RDG.string().next();
    private String url;
    private String address;
    private String postCode;
    private GeoLocation geoLocation = new GeoLocationBuilder().build();

    public ThingyBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ThingyBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public ThingyBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public ThingyBuilder withPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public ThingyBuilder withGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
        return this;
    }

    public Thingy build() {
        Thingy thingy = new Thingy(
                this.name,
                this.url,
                this.address,
                this.postCode,
                this.geoLocation
        );

        return thingy;
    }
}
