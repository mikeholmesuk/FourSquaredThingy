package com.tech.mike.service;

import com.google.common.annotations.VisibleForTesting;
import com.tech.mike.client.foursquare.FourSquareClient;
import com.tech.mike.client.foursquare.dto.Response;
import com.tech.mike.client.foursquare.dto.Result;
import com.tech.mike.client.foursquare.dto.Venue;
import com.tech.mike.representation.GeoLocation;
import com.tech.mike.representation.Thing;
import com.tech.mike.representation.Thingy;
import com.tech.mike.exception.WtfException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ThingyService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FourSquareClient fourSquareClient;

    public ThingyService(FourSquareClient fourSquareClient) {
        this.fourSquareClient = fourSquareClient;
    }

    public Thing getThingiesForPlaceName(String placeName) {
        Result result = fourSquareClient.searchByPlaceName(placeName);

        if (result.getMeta().getCode() >= 200 && result.getMeta().getCode() <300) {
            return mapResponseToThing(result.getResponse());
        }
        else {
            throw new WtfException(result.getMeta().getErrorDetail(), result.getMeta().getCode());
        }
    }

    public Thing getTrendingThingiesForPLaceName(String placeName) throws WtfException {
        Result result = fourSquareClient.trendingByPlaceName(placeName);

        if (result.getMeta().getCode() >= 200 && result.getMeta().getCode() <300) {
            return mapResponseToThing(result.getResponse());
        }
        else {
            throw new WtfException(result.getMeta().getErrorDetail(), result.getMeta().getCode());
        }
    }

    private Thing mapResponseToThing(Response response) {
        return new Thing(
                response.getGeoCode().getWhere(),
                new GeoLocation(
                        response.getGeoCode().getFeature().getGeometry().getCentre().getLongitude(),
                        response.getGeoCode().getFeature().getGeometry().getCentre().getLatitude()
                ), mapVenuesToThingies(response.getVenues()));
    }

    private List<Thingy> mapVenuesToThingies(List<Venue> venues) {
        List<Thingy> thingies = new ArrayList<Thingy>();

        for(Venue venue : venues) {
            thingies.add(new Thingy(
                    venue.getName(),
                    venue.getUrl(),
                    venue.getAddress().getAddressLine(),
                    venue.getAddress().getPostalCode(),
                    new GeoLocation(venue.getAddress().getLongitude(), venue.getAddress().getLatitude())
            ));
        }

        return thingies;
    }
}
