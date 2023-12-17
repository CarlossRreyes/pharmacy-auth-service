package pharmacy.auth.entities;


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
@Table( name = "permission" )
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_permission", columnDefinition = "int4")
    private Integer id_permission;

    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = true)
    private Menu menu;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_user_type", nullable = true)
    private UserType userType;
    
    @Column(name = "state", length = 1)
    private String state;
    
}
