package com.tech.mike.resource.api;

import com.tech.mike.builder.ThingBuilder;
import com.tech.mike.builder.ThingyBuilder;
import com.tech.mike.exception.ThingException;
import com.tech.mike.representation.Thing;
import com.tech.mike.representation.Thingy;
import com.tech.mike.service.ThingyService;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import uk.org.fyodor.generators.RDG;
import uk.org.fyodor.generators.characters.CharacterSetFilter;
import uk.org.fyodor.range.Range;

import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

public class ThingResourceTest {

    private ThingyService thingyServiceMock = mock(ThingyService.class);;
    @Rule
    public ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ThingResource(thingyServiceMock))
            .build();

    @Before
    public void setup() {
        reset(thingyServiceMock);
    }

    @Test
    public void getWithValidPlaceName_returnsStatusCode200() {
        // Given
        String validPlaceName = RDG.string(Range.closed(3, 20), CharacterSetFilter.LettersAndDigits).next();
        Thing thing = new ThingBuilder().build();

        // When
        when(thingyServiceMock.getThingiesForPlaceName(eq(validPlaceName))).thenReturn(thing);
        Response response = resources.client().target("/api/thing/near/" + validPlaceName).request().get();

        // Then
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void getWithValidPlaceName_returnsEntityOfTypeThing() {
        // Given
        String validPlaceName = RDG.string(Range.closed(3, 20), CharacterSetFilter.LettersAndDigits).next();
        Thing thing = new ThingBuilder()
                .withDisplayName(validPlaceName)
                .withAddedThingy(new ThingyBuilder().build())
                .build();

        // When
        when(thingyServiceMock.getThingiesForPlaceName(eq(validPlaceName))).thenReturn(thing);
        Thing thingResponse = resources.client().target("/api/thing/near/" + validPlaceName).request().get(Thing.class);

        // Then
        assertThat(thingResponse).isInstanceOf(Thing.class);
    }

    @Test
    public void getWithValidPlaceName_returnsExpectedNumberOfThings() {
        // Given
        String validPlaceName = RDG.string(Range.closed(3, 20), CharacterSetFilter.LettersAndDigits).next();
        List<Thingy> thingies = new ArrayList<Thingy>();
        Integer numberOfThings = RDG.integer(Range.closed(2, 50)).next();
        for (int i = 0; i < numberOfThings; i++) {
            thingies.add(new ThingyBuilder().build());
        }

        Thing thing = new ThingBuilder()
                .withDisplayName(validPlaceName)
                .withThingies(thingies)
                .build();

        // When
        when(thingyServiceMock.getThingiesForPlaceName(eq(validPlaceName))).thenReturn(thing);
        Thing thingResponse = resources.client().target("/api/thing/near/" + validPlaceName).request().get(Thing.class);

        // Then
        assertThat(thingResponse.getThingies()).hasSize(numberOfThings);
    }

    @Test
    public void serviceExceptionError_returnsEqualHttpCode() {
        // Given
        String errorGeneratingName = RDG.string(Range.closed(3, 20), CharacterSetFilter.LettersAndDigits).next();

        // When
        when(thingyServiceMock.getThingiesForPlaceName(errorGeneratingName)).thenThrow(
                new ThingException(RDG.string().next(), 500));
        Response response = resources.client().target("/api/thing/near/" + errorGeneratingName).request().get();

        // Then
        assertThat(response.getStatus()).isEqualTo(500);
    }
}
