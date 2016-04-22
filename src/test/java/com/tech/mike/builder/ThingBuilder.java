package com.tech.mike.builder;

import com.tech.mike.representation.*;
import uk.org.fyodor.generators.RDG;

import java.util.ArrayList;
import java.util.List;

public class ThingBuilder {
    private String displayName = RDG.string().next();
    private GeoLocation geoLocation;
    private List<Thingy> thingies = new ArrayList<Thingy>();

    public ThingBuilder withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public ThingBuilder withGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
        return this;
    }

    public ThingBuilder withThingies(List<Thingy> thingies) {
        this.thingies = thingies;
        return this;
    }

    public ThingBuilder withAddedThingy(Thingy thingy) {
        if (this.thingies != null) {
            thingies.add(thingy);
        }
        return this;
    }

    public Thing build() {
        Thing thing = new Thing(
                this.displayName,
                this.geoLocation,
                this.thingies
        );

        return thing;
    }
}
