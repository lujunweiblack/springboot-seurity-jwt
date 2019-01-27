package com.example.seurity.config;

import com.example.seurity.common.JwtTokenUtil;
import com.example.seurity.model.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.seurity.model.ResultBean.SUCCESS;

@Slf4j
@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException{
        log.info("############ 登录成功 ##############");
        User userDetails = (User) authentication.getPrincipal();
        String jwtToken = JwtTokenUtil.generateToken(userDetails.getUsername(), 3000, "_secret");
        httpServletResponse.getWriter().write(ResultBean.resultInit(SUCCESS,"Login Success!",jwtToken));
    }
}

