package com.tech.mike.representation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.mike.builder.GeoLocationBuilder;
import io.dropwizard.jackson.Jackson;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static io.dropwizard.testing.FixtureHelpers.*;

public class GeoLocationTest {
    private ObjectMapper mapper;

    @Before
    public void setup() {
        this.mapper = Jackson.newObjectMapper();
    }

    // Serialis(z)ation
    @Test
    public void validGeolocationSerialised_returnsEqualJson() throws Exception {
        // Given
        GeoLocation geolocation = new GeoLocationBuilder()
                .withLongAndLat(90.0, 45.0)
                .build();

        // When
        String serialisedGeolocation = mapper.writeValueAsString(geolocation);

        // Then
        assertThat(serialisedGeolocation).isEqualTo(fixture("fixtures/geolocations/geolocation.json"));
    }

    // Deserialis(z)ation
    @Test
    public void validGeolocationDeserialised_returnsEqualObject() throws Exception {
        // Given
        GeoLocation geolocation = new GeoLocationBuilder()
                .withLongAndLat(90.0, 45.0)
                .build();

        // When
        GeoLocation geolocationObject = mapper.readValue(fixture("fixtures/geolocations/geolocation.json"), GeoLocation.class);

        // Then
        assertThat(geolocation).isEqualToComparingFieldByField(geolocationObject);
    }

    //Validation

}
