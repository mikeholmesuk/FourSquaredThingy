package com.tech.mike.client.foursquare;

import com.tech.mike.client.foursquare.dto.Category;
import com.tech.mike.client.foursquare.dto.Result;
import com.tech.mike.config.FourSquareConfiguration;
import com.tech.mike.client.foursquare.dto.Venue;
import com.tech.mike.client.ClientHttpHelper;
import com.tech.mike.client.DtoMapper;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FourSquareClient {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FourSquareConfiguration configuration;
    private final ClientHttpHelper httpHelper;
    private final DtoMapper dtoMapper;

    public FourSquareClient(FourSquareConfiguration configuration, ClientHttpHelper httpHelper, DtoMapper dtoMapper) {
        this.configuration = configuration;
        this.httpHelper = httpHelper;
        this.dtoMapper = dtoMapper;
    }

    public Result searchByPlaceName(String placeName) {
        logger.debug("Retrieving venues for " + placeName);

        List<NameValuePair> params = getBaseServiceParams();
        params.add(new BasicNameValuePair("near", placeName));

        HttpGet httpGet = new HttpGet(httpHelper.buildRequest(configuration.getHostUrl(), "/venues/search", params));

        Result result = dtoMapper.mapStreamToObject(httpHelper.getResponseContentAsStream(httpGet), Result.class);

        return result;
    }

    public Result trendingByPlaceName(String placeName) {
        logger.debug("Retrieving trending venues for " + placeName);

        List<NameValuePair> params = getBaseServiceParams();
        params.add(new BasicNameValuePair("near", placeName));

        HttpGet httpGet = new HttpGet(httpHelper.buildRequest(configuration.getHostUrl(), "/venues/trending", params));

        Result result = dtoMapper.mapStreamToObject(httpHelper.getResponseContentAsStream(httpGet), Result.class);

        return result;
    }

    public List<Category> getAllVenueCategories() {
        logger.debug("Retrieving categories from FourSQuare");

        List<NameValuePair> params = getBaseServiceParams();

        HttpGet httpGet = new HttpGet(httpHelper.buildRequest(configuration.getHostUrl(), "/venues/categories", params));

        Result result = dtoMapper.mapStreamToObject(httpHelper.getResponseContentAsStream(httpGet), Result.class);

        return result.getResponse().getCategories();
    }

    private List<NameValuePair> getBaseServiceParams() {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("client_id", configuration.getClientId()));
        params.add(new BasicNameValuePair("client_secret", configuration.getClientSecret()));
        params.add(new BasicNameValuePair("v", configuration.getApiVersion()));

        return params;
    }
}
