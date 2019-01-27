package com.example.seurity.config;

import com.example.seurity.model.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.seurity.model.ResultBean.UN_AUTHORIZED;

@Slf4j
@Component
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        log.info("############ 未授权或token过期 ##############");
        httpServletResponse.getWriter().write(ResultBean.resultInit(UN_AUTHORIZED,"Need Authorities!"));
    }
}
