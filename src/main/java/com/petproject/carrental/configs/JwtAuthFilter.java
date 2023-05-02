package com.petproject.carrental.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UserAuthenticationProvider userAuthenticationProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (header != null) {
            String[] elements = header.split(" ");

            if (elements.length == 2 && "Bearer".equals(elements[0])) {
                try {
                    SecurityContextHolder.getContext().setAuthentication(
                            userAuthenticationProvider.validateToken(elements[1]));
                } catch (RuntimeException exception) {
                    SecurityContextHolder.clearContext();
                    throw exception;
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
