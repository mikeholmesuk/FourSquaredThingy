package com.tech.mike.service;

import com.tech.mike.builder.foursquare.*;
import com.tech.mike.client.foursquare.FourSquareClient;
import com.tech.mike.client.foursquare.dto.Result;
import com.tech.mike.client.foursquare.dto.Venue;
import com.tech.mike.exception.ThingException;
import com.tech.mike.representation.Thing;
import org.junit.Before;
import org.junit.Test;
import uk.org.fyodor.generators.RDG;
import uk.org.fyodor.range.Range;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

public class ThingyServiceTest {

    private FourSquareClient mockedFourSquareClient;
    private ThingyService thingyService;

    @Before
    public void setup() {
        mockedFourSquareClient = mock(FourSquareClient.class);
        thingyService = new ThingyService(mockedFourSquareClient);
    }

    @Test
    public void validPlaceName_returnsThingWithSameValueAsName() {
        // Given
        String randomSearchString = RDG.string().next();
        // Bit clunky - could do with a hug
        Result mockedResult = new ResultBuilder()
                .withResponse(new ResponseBuilder()
                        .withGeoCode(new GeoCodeBuilder()
                            .withWhere(randomSearchString)
                                .build())
                        .build())
                .build();

        // When
        when(mockedFourSquareClient.searchByPlaceName(eq(randomSearchString))).thenReturn(mockedResult);
        Thing thingResult = thingyService.getThingiesForPlaceName(randomSearchString);

        // Then
        assertThat(thingResult.getDisplayName()).isEqualTo(randomSearchString);
    }

    @Test
    public void validPlaceNameWithVenues_returnsSameNumberOfThingsAsVenues() {
        // Given
        String randomSearchString = RDG.string().next();
        Integer venuesToGenerate = RDG.integer(Range.closed(1, 50)).next();
        List<Venue> randomVenueList = new ArrayList<>();
        for (int i = 0; i < venuesToGenerate; i++) {
            randomVenueList.add(new VenueBuilder().build());
        }
        Result mockedResult = new ResultBuilder()
                .withResponse(new ResponseBuilder().withVenues(randomVenueList).build())
                .build();

        // When
        when(mockedFourSquareClient.searchByPlaceName(eq(randomSearchString))).thenReturn(mockedResult);
        Thing thingResult = thingyService.getThingiesForPlaceName(randomSearchString);

        // Then
        assertThat(thingResult.getThingies()).isNotEmpty().isNotNull().hasSize(venuesToGenerate);
    }

    @Test
    public void validPlaceNameWithNoVenues_returnsEmptyThingies() {
        // Given
        String randomSearchString = RDG.string().next();
        Result mockedResult = new ResultBuilder().build();

        // When
        when(mockedFourSquareClient.searchByPlaceName(eq(randomSearchString))).thenReturn(mockedResult);
        Thing thingResult = thingyService.getThingiesForPlaceName(randomSearchString);

        // Then
        assertThat(thingResult.getThingies()).isNotNull().isEmpty();
    }

    @Test(expected = ThingException.class)
    public void invalidPlaceName_throwsException() {
        // Given
        String randomSearchString = RDG.string().next();
        Result mockedResult = new ResultBuilder().withMeta(
                new MetaBuilder().withCode(404).build()
        ).build();

        // When
        when(mockedFourSquareClient.searchByPlaceName(eq(randomSearchString))).thenReturn(mockedResult);
        thingyService.getThingiesForPlaceName(randomSearchString);

        // Then
        // caught exception
    }


}
