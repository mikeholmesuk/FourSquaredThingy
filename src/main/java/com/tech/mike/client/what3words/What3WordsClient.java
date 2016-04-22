package com.tech.mike.client.what3words;

import com.tech.mike.config.What3WordsConfiguration;
import com.tech.mike.client.foursquare.dto.Location;
import com.tech.mike.client.what3words.dto.Position;
import com.tech.mike.client.ClientHttpHelper;
import com.tech.mike.client.DtoMapper;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class What3WordsClient {
    private Logger logger = Logger.getLogger(this.getClass().getCanonicalName());

    // Async stuff here maybe?

    private final ClientHttpHelper httpHelper;
    private final DtoMapper dtoMapper;
    private final What3WordsConfiguration configuration;

    public What3WordsClient(What3WordsConfiguration config, ClientHttpHelper httpHelper, DtoMapper dtoMapper) {
        this.httpHelper = httpHelper;
        this.dtoMapper = dtoMapper;
        this.configuration = config;
    }

    public Position getPositionFromWords(String words) {
        logger.debug("Retrieving location from words: ");

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("key", configuration.getApiKey()));
        params.add(new BasicNameValuePair("string", words));

        HttpGet httpGet = new HttpGet(httpHelper.buildRequest(configuration.getHostUrl(), "/w3w", params));

        Position position = dtoMapper.mapStreamToObject(httpHelper.getResponseContentAsStream(httpGet), Position.class);

        return position;
    }

    public Position getPositionFromLocation(Location location) {
        logger.debug("Retrieving words from location: ");

        return new Position();
    }

    private List<NameValuePair> getBaseServiceParams() {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("key", configuration.getApiKey()));

        return params;
    }
}
