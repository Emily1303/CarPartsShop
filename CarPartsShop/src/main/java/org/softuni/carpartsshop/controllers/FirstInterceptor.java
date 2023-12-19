package org.softuni.carpartsshop.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Component
public class FirstInterceptor implements HandlerInterceptor {

//    this interceptor is for logging - in the log are present the HTTP methods, URLs and Cookies of the
//    request; the status of the response and a message if the response is visible for the client
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        try {
            System.out.println("Request info:");
            System.out.println("Method: " + request.getMethod());
            System.out.println("URL: " + request.getRequestURI());
            System.out.println(String.join("; ", Arrays.toString(request.getCookies())));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {

        try {
            System.out.println("-------------------------------------------");
            System.out.println("Response info: ");
            System.out.println(response.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {

        try {
            System.out.println("-------------------------------------------");
            System.out.println("Everything is loaded!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
