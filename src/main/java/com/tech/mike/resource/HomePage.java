package com.tech.mike.resource;

import com.codahale.metrics.annotation.Timed;
import com.tech.mike.views.HomeView;
import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class HomePage {

    @GET
    @Timed
    public View getHomePage() {
        return new HomeView();
    }
}
