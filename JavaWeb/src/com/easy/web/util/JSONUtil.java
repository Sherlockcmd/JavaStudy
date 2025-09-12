package com.easy.web.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JSONUtil {
    private JSONUtil() {
    }

    public static void toJSON(HttpServletResponse resp, Object object) {
        try {
            resp.setContentType("text/html;charset=UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getWriter(), object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
