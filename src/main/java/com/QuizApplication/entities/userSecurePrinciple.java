package com.QuizApplication.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
public class userSecurePrinciple implements UserDetails {
    public User Securitymodel;

    public userSecurePrinciple() {
    }

    public userSecurePrinciple(User Securitymodel) {
        this.Securitymodel= Securitymodel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("Securitymodel"));
    }

    @Override
    public String getPassword() {
        return  Securitymodel.password;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public String getUsername() {
        return Securitymodel.username;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
