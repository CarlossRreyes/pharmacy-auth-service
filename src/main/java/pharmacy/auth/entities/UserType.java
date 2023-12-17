package pharmacy.auth.entities;


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
@Table(name = "user_type" )
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_user_type", columnDefinition = "int4")
    private Integer id_user_type;

    @Column(name = "user_type", length = 40)
    private String user_type;

    @Column(name = "state", length = 1)
    private String state;

   
}
