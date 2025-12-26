package com.sbitech.filter;

import com.sbitech.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        /* 1. 从请求头中获取 Authorization 字段，格式：Bearer <token> */
        String authorizationHeader = request.getHeader("Authorization");
        /* 2. 仅当携带了 Bearer 令牌时才处理 */
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            /* 2.1 去掉 "Bearer " 前缀，得到纯 JWT */
            String token = authorizationHeader.substring(7);
            try {
                /* 2.2 验签 + 过期检查 */
                if (jwtUtil.validateToken(token)) {
                    /* 2.3 解析用户名与角色 */
                    String username = jwtUtil.getUsernameFromToken(token);
                    String role = jwtUtil.getRoleFromToken(token);

                    /* 2.4 构造 Spring Security 授权对象（已认证） */
                    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(username, null, authorities);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    /* 2.5 放入 SecurityContext，后续过滤器链可直接取 */
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e) {
                /* 2.6 验签失败记录日志，但不阻断请求，交给后续过滤器返回 401/403 */
                logger.error("JWT Token validation failed", e);
            }
        }

        filterChain.doFilter(request, response);
    }
}