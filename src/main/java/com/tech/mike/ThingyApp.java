package com.tech.mike;

import com.tech.mike.client.foursquare.FourSquareClient;
import com.tech.mike.client.what3words.What3WordsClient;
import com.tech.mike.client.ClientHttpHelper;
import com.tech.mike.client.DtoMapper;
import com.tech.mike.resource.HomePage;
import com.tech.mike.resource.api.ThingResource;
import com.tech.mike.service.ThingyService;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThingyApp extends Application<ThingyConfig> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) throws Exception {
        new ThingyApp().run(args);
    }

    public void initialize(Bootstrap<ThingyConfig> bootstrap) {
        bootstrap.addBundle(new ViewBundle());

        bootstrap.addBundle(new AssetsBundle("/css", "/css", null, "css"));
        bootstrap.addBundle(new AssetsBundle("/js", "/js", null, "js"));
    }

    public void run(ThingyConfig config, Environment environment) throws ClassNotFoundException {
        logger.debug("Running 'Four Square Thingy' application....");

        // Setup necessary clients
        What3WordsClient what3WordsClient = new What3WordsClient(config.getW3wConfig(), new ClientHttpHelper(), new DtoMapper());
        FourSquareClient fourSquareClient = new FourSquareClient(config.getFourSquareConfig(), new ClientHttpHelper(), new DtoMapper());

        // Setup services used in the application
        ThingyService thingyService = new ThingyService(fourSquareClient);

        // Main page for the application
        environment.jersey().register(new HomePage());
        // API resources
        environment.jersey().register(new ThingResource(thingyService));
    }
}
