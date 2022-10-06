package com.dv.util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.dv.model.AbstractModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {

    public static <T extends AbstractModel> T toModel(String jsonValue, Class<T> clazz) {
        T model = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            model = mapper.readValue(jsonValue, clazz);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return model;
    }

    public static String toJson(HttpServletRequest req) {
        BufferedReader bufferedReader = null;

        String line = "";
        StringBuilder data = new StringBuilder();
        try {
            bufferedReader = req.getReader();
            if (bufferedReader != null) {
                while ((line = bufferedReader.readLine()) != null) {
                    data.append(line);
                }
            }
        } catch (IOException e) {
        }
        String jsonValue = data.toString();
        return jsonValue;
    }

    public static <T> String toJson(T model) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonValue = null;
        try {
            jsonValue = mapper.writeValueAsString(model);
        } catch (JsonProcessingException e) {
        }
        return jsonValue;
    }
}