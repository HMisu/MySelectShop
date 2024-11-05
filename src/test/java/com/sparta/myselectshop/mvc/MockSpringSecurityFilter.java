// package com.sparta.myselectshop.mvc;
//
// import jakarta.servlet.*;
// import jakarta.servlet.http.HttpServletRequest;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
//
// import java.io.IOException;
//
// // Mockito처럼 가짜 필터를 만들어주어 테스트
// // 왜냐하면 기존의 시큐리티가 작동하면 테스트 수행 시 방해가 될 수 있음
// public class MockSpringSecurityFilter implements Filter {
//
//     @Override
//     public void init(FilterConfig filterConfig) {
//     }
//
//     // SecurityContextHolder : 인증 객체를 담는 공간
//     @Override
//     public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//         SecurityContextHolder.getContext()
//                 .setAuthentication((Authentication) ((HttpServletRequest) req).getUserPrincipal());
//         chain.doFilter(req, res);
//     }
//
//     @Override
//     public void destroy() {
//         SecurityContextHolder.clearContext();
//     }
// }