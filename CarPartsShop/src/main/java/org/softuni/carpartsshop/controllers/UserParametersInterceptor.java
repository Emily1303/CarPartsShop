package org.softuni.carpartsshop.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class UserParametersInterceptor implements HandlerInterceptor {

//    adding Interceptor that shows in the log the currently logged user with his/her session and
//    the view that is loaded

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (isUserLogged()) {
            addToModelUserDetails(request.getSession());
        }

        return true;
    }

    public static boolean isUserLogged() {
        try {
            return !SecurityContextHolder.getContext().getAuthentication()
                    .getName().equals("anonymousUser");
        } catch (Exception e) {
            return false;
        }
    }

    private void addToModelUserDetails(HttpSession httpSession) {
        System.out.println("----------------------------------------------");
        String loggedUsername = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        httpSession.setAttribute("username", loggedUsername);

        System.out.println("------" + loggedUsername + "--------" + httpSession);
    }

    private void addToModelUserDetails(ModelAndView modelAndView) {
        System.out.println("-------------------------------------------------");
        String loggedUsername =
                SecurityContextHolder.getContext().getAuthentication().getName();

        modelAndView.addObject("loggedUsername", loggedUsername);

        System.out.println("-------" + modelAndView.getModel() + "-----------");
    }

}
