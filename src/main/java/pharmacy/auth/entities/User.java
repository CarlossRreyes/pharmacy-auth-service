package pharmacy.auth.entities;


import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "user" )
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_user", columnDefinition = "int4")
    private Integer id_user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_person", nullable = true)
    private Person person;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_user_type", nullable = true)
    private UserType userType;

    @Column(name = "email", length = 110)
    private String email;

    @JsonIgnore
    @Column(name = "password", length = 150)
    private String password;

    @Column(name = "state", length = 1)
    private String state;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }
    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }
    @JsonIgnore
    @Override
    public String getUsername() {
        return email;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
       return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
       return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    
}
