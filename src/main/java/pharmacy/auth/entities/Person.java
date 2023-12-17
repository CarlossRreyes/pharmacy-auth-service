package pharmacy.auth.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "person" )
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_person", columnDefinition = "int4")
    private Integer id_person;


    @Column(name = "identification", length = 10)
    private String identification;

    @Column(name = "names", length = 40)
    private String names;

    @Column(name = "last_name", length = 40)
    private String last_name;

}
