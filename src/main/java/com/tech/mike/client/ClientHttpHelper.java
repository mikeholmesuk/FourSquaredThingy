package com.tech.mike.client;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class ClientHttpHelper {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public URI buildRequest(String host, String targetPath, List<NameValuePair> requestParameters) {
        URI uri = null;
        try {
            uri = new URIBuilder()
                    .setScheme("http")
                    .setHost(host)
                    .setPath(targetPath)
                    .setParameters(requestParameters)
                    .build();
        }
        catch(URISyntaxException use) {
            logger.error("Exception caught when constructing URI: " + use.getMessage());
            use.printStackTrace();
        }
        return uri;
    }

    public InputStream getResponseContentAsStream(HttpRequestBase httpRequest) {
        InputStream stream = null;
        try {
            stream = executeRequest(httpRequest).getEntity().getContent();
        }
        catch(IOException ioe) {
            logger.error("IO Exception caught when retrieving response content: " + ioe.getMessage());
            ioe.printStackTrace();
        }
        catch(UnsupportedOperationException uoe) {
            logger.error("Unsupported Operation Exception caught when retrieving response content: " + uoe.getMessage());
            uoe.printStackTrace();
        }
        return stream;
    }

    private HttpResponse executeRequest(HttpRequestBase httpRequest) {
        logger.trace("Executing " + httpRequest.getMethod() + " request: " + httpRequest.getURI());
        HttpResponse httpResponse = null;

        try {
            httpResponse = HttpClients.createDefault().execute(httpRequest);
        }
        catch (IOException ioe) {
            logger.error("IOException caught when executing " + httpRequest.getMethod() + " request against  " + httpRequest.getURI());
            ioe.printStackTrace();
        }

        return httpResponse;
    }
}
