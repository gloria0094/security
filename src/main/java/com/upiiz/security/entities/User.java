package com.upiiz.security.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "tbl_usuarios")
@Entity
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    //Distingue entre mayusculas y minusculas
    @Column(nullable = false, name = "full_name")
    //Aclaramos que en JSON viene fullname del cliente
    @JsonProperty("fullname")
    private String fullName;

    public void setPasswordCodificado(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        //Es cierto, la cuenta no expira
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //Es cierto, la cuenta con esta bloqueda
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //Es cierto, las credenciales no expiran
        return true;
    }

    @Override
    public boolean isEnabled() {
        //Es cierto, el usuario siempre estara activo
        return true;
    }


}
