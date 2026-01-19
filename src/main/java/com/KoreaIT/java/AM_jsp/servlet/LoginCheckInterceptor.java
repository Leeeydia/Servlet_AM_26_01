package com.KoreaIT.java.AM_jsp.servlet;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpRequest request, HttpResponse response, Object handler) throws Exception {

        // 1. 세션에서 회원 정보 조회
        HttpSession session = request.getSession();
        MemberResponse member = (MemberResponse) session.getAttribute("loginMember");

        // 2. 회원 정보 체크
        if (member == null || member.getDeleteYn() == true) {
            response.sendRedirect("/login.do");
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

