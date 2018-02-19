package com.ploverbay.ticketing.authentication.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

    /**
     * Convert object to JSON string
     *
     * @param obj
     * @return String
     */
    public static String objectToJsonString(Object obj) throws JsonProcessingException {
        String jsonString = null;
        if (obj != null) {
            ObjectMapper mapper = new ObjectMapper();
            jsonString = mapper.writeValueAsString(obj);
        }
        return jsonString;
    }

    /**
     * Convert object to wrapped JSON string to a certain string property (ie. "data")
     *
     * @param obj
     * @param wrapper
     * @return String
     */
    public static String objectToJsonResponseAsString(Object obj, String wrapper) throws JsonProcessingException {
        String jsonString = null;
        if (obj != null) {
            jsonString = objectToJsonString(obj);
            if (wrapper != null) {
                jsonString = "{\"" + wrapper + "\": " + jsonString + "}";
            }
            return jsonString;
        }
        return jsonString;
    }

}
