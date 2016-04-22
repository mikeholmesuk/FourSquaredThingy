package com.tech.mike.representation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.mike.builder.GeoLocationBuilder;
import com.tech.mike.builder.ThingyBuilder;
import io.dropwizard.jackson.Jackson;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static io.dropwizard.testing.FixtureHelpers.*;

public class ThingyTest {
    private ObjectMapper mapper;

    @Before
    public void setup() {
        mapper = Jackson.newObjectMapper();
    }

    @Test
    public void allValidThingySerialised_returnsEqualJson() throws Exception {
        // Given
        Thingy thingy = new ThingyBuilder()
                .withName("My thingy")
                .withUrl("http://the.thing.com")
                .withAddress("1 Thingy Crescent")
                .withPostCode("th1 1ng")
                .withGeoLocation(new GeoLocationBuilder().withLongAndLat(90.0, 45.0).build())
                .build();

        // When
        String serialisedThingy = mapper.writeValueAsString(thingy);

        // Then
        assertThat(serialisedThingy).isEqualToIgnoringWhitespace(fixture("fixtures/thingies/thingy.json"));
    }

    @Test
    public void noAddressThingySerialised_returnsEqualJson() throws Exception {
        // Given
        Thingy thingy = new ThingyBuilder()
                .withName("My thingy")
                .withUrl("http://the.thing.com")
                .withAddress(null)
                .withPostCode("th1 1ng")
                .withGeoLocation(new GeoLocationBuilder().withLongAndLat(90.0, 45.0).build())
                .build();

        // When
        String serialisedThingy = mapper.writeValueAsString(thingy);

        // Then
        assertThat(serialisedThingy).isEqualToIgnoringWhitespace(fixture("fixtures/thingies/thingy_without_address.json"));
    }

    @Test
    public void noPostcodeThingySerialised_returnsEqualJson() throws Exception {
        // Given
        Thingy thingy = new ThingyBuilder()
                .withName("My thingy")
                .withUrl("http://the.thing.com")
                .withAddress("1 Thingy Crescent")
                .withPostCode(null)
                .withGeoLocation(new GeoLocationBuilder().withLongAndLat(90.0, 45.0).build())
                .build();

        // When
        String serialisedThingy = mapper.writeValueAsString(thingy);

        // Then
        assertThat(serialisedThingy).isEqualToIgnoringWhitespace(fixture("fixtures/thingies/thingy_without_postcode.json"));
    }
}
