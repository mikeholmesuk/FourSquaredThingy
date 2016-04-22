package com.tech.mike.representation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.mike.builder.GeoLocationBuilder;
import com.tech.mike.builder.ThingBuilder;
import com.tech.mike.builder.ThingyBuilder;
import io.dropwizard.jackson.Jackson;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static io.dropwizard.testing.FixtureHelpers.*;

public class ThingTest {
    private ObjectMapper mapper;

    @Before
    public void setup() {
        mapper = Jackson.newObjectMapper();
    }

    @Test
    public void thingWithOneThingySerialised_returnsEqualJson() throws Exception {
        // Given
        Thing thing = new ThingBuilder()
                .withDisplayName("My Great Thing")
                .withGeoLocation(new GeoLocationBuilder().withLongAndLat(90.0, 45.0).build())
                .withAddedThingy(new ThingyBuilder()
                    .withName("My thingy")
                    .withUrl("http://the.thing.com")
                    .withAddress("1 Thingy Crescent")
                    .withPostCode("th1 1ng")
                    .withGeoLocation(new GeoLocationBuilder().withLongAndLat(90.0, 45.0).build())
                    .build())
                .build();

        // When
        String serialisedThing = mapper.writeValueAsString(thing);

        // Then
        assertThat(serialisedThing).isEqualTo(fixture("fixtures/things/thing_with_1_thingy.json"));
    }

    @Test
    public void thingWithNoThingiesSerialised_returnsEqualJson() throws Exception {
        // Given
        Thing thing = new ThingBuilder()
                .withDisplayName("My Great Thing")
                .withGeoLocation(new GeoLocationBuilder().withLongAndLat(90.0, 45.0).build())
                .build();

        // When
        String serialisedThing = mapper.writeValueAsString(thing);

        // Then
        assertThat(serialisedThing).isEqualTo(fixture("fixtures/things/thing_without_thingies.json"));
    }
}
