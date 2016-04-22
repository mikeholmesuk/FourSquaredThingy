package com.tech.mike.resource.api;

import com.tech.mike.representation.Thing;
import com.tech.mike.representation.Thingy;
import com.tech.mike.service.ThingyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/thing")
@Produces(MediaType.APPLICATION_JSON)
public class ThingResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ThingyService thingyService;

    public ThingResource(ThingyService thingyService) {
        this.thingyService = thingyService;
    }

    @GET
    @Path("/near/{place_name}")
    public Thing getVenuesNearPlaceName(@PathParam("place_name") String placeName) {
        logger.debug("Near: " + placeName);

        return thingyService.getThingiesForPlaceName(placeName);
    }

    @GET
    @Path("/near/{place_name}/trending")
    public Thing getTrendingVenuesNearPlaceName(@PathParam("place_name") String placeName) {
        logger.debug("Trending near: " + placeName);

        return thingyService.getTrendingThingiesForPLaceName(placeName);
    }
}