package pl.edu.knbit.bitjava.shop.security.jwt;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import pl.edu.knbit.bitjava.shop.domain.client.Client;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by surjak on 08.01.2021
 */
public class InvoiceFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        Client client = (Client)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String clientId = httpServletRequest.getServletPath().split("/")[2];

        if(!client.getId().toString().equals(clientId)){
            throw new IOException("ID of client is not equal to the ID in path");
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().matches("/clients/[A-Za-z0-9\\-]*/invoices");
    }
}
