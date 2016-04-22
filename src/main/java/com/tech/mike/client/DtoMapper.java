package com.tech.mike.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

public class DtoMapper {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public <T extends Object> T mapStreamToObject(InputStream stream, Class<T> clazz) {
        T obj = null;

        try {
            obj = new ObjectMapper().readValue(stream, clazz);
        }
        catch(Exception e) {
            logger.error("Exception caught when trying to map input stream to " + clazz.getSimpleName() + " object");
        }

        return obj;
    }

    public <T extends Object> List<T> mapStreamToObjectList(InputStream stream, Class<T> clazz) {
        List<T> objs = null;

        try {
            objs = new ObjectMapper().readValue(stream, new TypeReference<List<T>>(){});
        }
        catch(Exception e) {
            logger.error("Exception caught when trying to map input stream to list of " + clazz.getSimpleName() + " objects");
        }

        return objs;
    }
}
