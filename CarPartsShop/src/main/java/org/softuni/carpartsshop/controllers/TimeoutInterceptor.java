package org.softuni.carpartsshop.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeoutInterceptor implements HandlerInterceptor {

//    this Interceptor is used to track the time for which a request is handled;
//    it logs out a user that is inactive more than 100000 ms and he/she is redirected to the index page 

    @Autowired
    private HttpSession httpSession;

    private static final long MAX_INACTIVE_TIME = 10 * 10000;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("--------------- Setting timer ------------");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        if (UserParametersInterceptor.isUserLogged()) {
            httpSession = request.getSession();
            System.out.printf("Time since last request in this session: %d ms",
                    System.currentTimeMillis() - request.getSession().getLastAccessedTime());
            System.out.println();

            if (System.currentTimeMillis() - httpSession.getLastAccessedTime() > MAX_INACTIVE_TIME) {
                System.out.println("Logging out because user is inactive!");
                SecurityContextHolder.clearContext();
                request.logout();
                response.sendRedirect("/");
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {

        System.out.println("----- Check time of handling request ----------");
        long startTime = (long) request.getAttribute("startTime");
        System.out.printf("Time for handling the request was: %d ms",
                System.currentTimeMillis() - startTime);
        System.out.println();
    }

}
