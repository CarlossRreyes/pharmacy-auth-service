package pharmacy.auth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pharmacy.auth.entities.Menu;

public interface IMenuRepository extends CrudRepository<Menu, Integer> {

    @Query(" SELECT m FROM Menu m WHERE m.state = 'A' AND m.id_menu_parent = 0 ")
    public List<Menu> searchMenuByIdMenuParent();

    @Query(" SELECT m FROM Menu m WHERE m.state = 'A' AND m.id_menu_parent = ?1 ")
    public List<Menu> searchMenuByIdMenuParentId( Integer id_menu_parent );

}
