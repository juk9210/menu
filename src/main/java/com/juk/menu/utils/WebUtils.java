package com.juk.menu.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Создаём класс WebUtils
 *
 * @author Shakhov Yevhen
 */

public class WebUtils {
    /**
     * @param user
     * @return
     */
    public static String toString(User user) {
        StringBuilder sb = new StringBuilder();

        sb.append( "UserName:" ).append( user.getUsername() );

        Collection<GrantedAuthority> authorities = user.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            sb.append( " (" );
            boolean first = true;
            for (GrantedAuthority a : authorities) {
                if (first) {
                    sb.append( a.getAuthority() );
                    first = false;
                } else {
                    sb.append( ", " ).append( a.getAuthority() );
                }
            }
            sb.append( ")" );
        }
        return sb.toString();
    }
}
