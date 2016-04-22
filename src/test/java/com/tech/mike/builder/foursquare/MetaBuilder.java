package com.tech.mike.builder.foursquare;

import com.tech.mike.client.foursquare.dto.Meta;
import uk.org.fyodor.generators.RDG;

public class MetaBuilder {
    private Integer code = 200; // Assume success
    private String errorType = RDG.string().next();
    private String errorDetail = RDG.string().next();
    private String requestId = String.valueOf(RDG.longVal().next());

    public MetaBuilder withCode(Integer code) {
        this.code = code;
        return this;
    }

    public MetaBuilder withErrorType(String errorType) {
        this.errorType = errorType;
        return this;
    }

    public MetaBuilder withErorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
        return this;
    }

    public MetaBuilder withRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public MetaBuilder withRequestId(Long requestId) {
        this.requestId = String.valueOf(requestId);
        return this;
    }

    public Meta build() {
        Meta meta = new Meta();
        meta.setCode(this.code);
        meta.setErrorType(this.errorType);
        meta.setErrorDetail(this.errorDetail);
        meta.setRequestId(this.requestId);
        return meta;
    }
}
