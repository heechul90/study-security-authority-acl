package study.spring.securityauthentication.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import study.spring.securityauthentication.core.domain.student.StudentAuthenticationToken;
import study.spring.securityauthentication.core.domain.teacher.TeacherAuthenticationToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerLoginFilter extends UsernamePasswordAuthenticationFilter {

    public CustomerLoginFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //username
        String username = obtainUsername(request);
        username = username != null ? username : "";
        username.trim();

        //password
        String password = obtainPassword(request);
        password = password != null ? password : "";
        String type = request.getParameter("type");
        if (type == null || !type.equals("teacher")) {
            //student
            StudentAuthenticationToken token = StudentAuthenticationToken.builder()
                    .credentials(username)
                    .build();
            return this.getAuthenticationManager().authenticate(token);
        } else {
            //teacher
            TeacherAuthenticationToken token = TeacherAuthenticationToken.builder()
                    .credentials(username)
                    .build();
            return this.getAuthenticationManager().authenticate(token);
        }
    }
}
