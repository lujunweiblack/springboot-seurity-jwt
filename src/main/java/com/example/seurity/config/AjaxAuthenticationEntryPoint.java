package com.example.seurity.config;

import com.example.seurity.model.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.seurity.model.ResultBean.NOT_LOGGED_IN;

@Slf4j
@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        log.info("############ 未登录 ##############");
        httpServletResponse.getWriter().write(ResultBean.resultInit(NOT_LOGGED_IN,"Need Authorities!"));
    }
}
