package com.example.seurity.config;

import com.example.seurity.model.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.seurity.model.ResultBean.SUCCESS;

@Slf4j
@Component
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        log.info("############ 已登出 ##############");
        httpServletResponse.getWriter().write(ResultBean.resultInit(SUCCESS, "Logout Success!"));
    }
}
