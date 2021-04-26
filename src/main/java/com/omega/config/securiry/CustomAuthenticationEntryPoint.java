package com.omega.config.securiry;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author thanhvt
 * @created 27/04/2021 - 12:33 SA
 * @project vengeance
 * @since 1.0
 **/
@Log4j2
@Primary
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, AuthenticationException ex)
        throws IOException {
        log.error(ex);
        PrintWriter out = httpServletResponse.getWriter();
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("code", 9999);
            jsonObject.put("message", ex.getLocalizedMessage());
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement: ex.getStackTrace()) {
                sb.append(stackTraceElement.toString()).append("\n");
            }
            jsonObject.put("detail", sb.toString());
        } catch (JSONException exception) {
            log.error(ex);
        }
        out.print(jsonObject);
        out.flush();
    }
}
