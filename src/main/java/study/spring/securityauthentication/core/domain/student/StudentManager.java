package study.spring.securityauthentication.core.domain.student;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class StudentManager implements AuthenticationProvider, InitializingBean {

    private HashMap<String, Student> studentDB = new HashMap<>();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        if (studentDB.containsKey(token.getName())) {
            Student student = studentDB.get(token.getName());
            return StudentAuthenticationToken.builder()
                    .principal(student)
                    .details(student.getUsername())
                    .authenticated(true)
                    .build();
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication == UsernamePasswordAuthenticationToken.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Set.of(
                new Student("kang", "강백호", Set.of(new SimpleGrantedAuthority("ROLE_USER"))),
                new Student("seo", "서태웅", Set.of(new SimpleGrantedAuthority("ROLE_USER"))),
                new Student("jeong", "정대만", Set.of(new SimpleGrantedAuthority("ROLE_USER"))),
                new Student("song", "정대만", Set.of(new SimpleGrantedAuthority("ROLE_USER"))),
                new Student("chae", "채치수", Set.of(new SimpleGrantedAuthority("ROLE_USER")))
        ).forEach(
                student -> studentDB.put(student.getId(), student)
        );
    }
}
