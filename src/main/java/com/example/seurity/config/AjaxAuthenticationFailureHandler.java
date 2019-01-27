package com.example.seurity.config;

import com.example.seurity.model.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.seurity.model.ResultBean.FAIL;

@Slf4j
@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        log.info("############ 登录失败 ##############");
        httpServletResponse.getWriter().write(ResultBean.resultInit(FAIL,"Login Failure!"));
    }
}
