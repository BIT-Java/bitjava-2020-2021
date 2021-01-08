package pl.edu.knbit.bitjava.shop.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import pl.edu.knbit.bitjava.shop.domain.client.Client;
import pl.edu.knbit.bitjava.shop.domain.client.ClientStorage;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by surjak on 08.01.2021
 */
public class JwtTokenVerifier extends OncePerRequestFilter {

    private final ClientStorage clientStorage;

    public JwtTokenVerifier(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader("Authorization");
        if(authHeader == null || authHeader.equals("") ||!authHeader.startsWith("Bearer")){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String token = authHeader.replace("Bearer ", "");
        try {
            String key = "securesecuresecuresecuresecuresecuresecuresecuresecure";

            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(key.getBytes()))
                    .parseClaimsJws(token);
            Claims jwsBody = claimsJws.getBody();
            String username = jwsBody.getSubject();

            Client client = (Client) clientStorage.loadUserByUsername(username);
            Collection<? extends GrantedAuthority> grantedAuthorities = client.getAuthorities();

            Authentication authentication = new UsernamePasswordAuthenticationToken(client, null, grantedAuthorities);
            SecurityContextHolder.getContext().setAuthentication(authentication); //stores for current thread
        }catch (JwtException e){
            throw new IllegalStateException("Token cannnot be trusted" + token);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
