package pharmacy.auth.entities;


import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu" )
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_menu", columnDefinition = "int4")
    private Integer id_menu;

    @Column( name = "id_menu_parent", columnDefinition = "int4" )
    private Integer id_menu_parent;

    @Column(name = "description", length = 40)
    private String description;

    @Size(max = 100)
	@Column(name = "url", length = 150)
	private String url;

    @Size(max = 100)
	@Column(name = "icon", length = 100)
	private String icon;

	@Column(name = "position", columnDefinition = "int4")
	private Integer position;

    @Column(name = "state", length = 1)
    private String state;

    @Transient
    private List<Menu> child;


    
}
