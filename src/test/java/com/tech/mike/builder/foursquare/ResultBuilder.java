package com.tech.mike.builder.foursquare;

import com.tech.mike.client.foursquare.dto.Meta;
import com.tech.mike.client.foursquare.dto.Response;
import com.tech.mike.client.foursquare.dto.Result;

public class ResultBuilder {
    private Meta meta = new MetaBuilder().build();
    private Response response = new ResponseBuilder().build();

    public ResultBuilder withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public ResultBuilder withResponse(Response response) {
        this.response = response;
        return this;
    }

    public Result build() {
        Result result = new Result(
                this.meta,
                this.response
        );
        return result;
    }
}
