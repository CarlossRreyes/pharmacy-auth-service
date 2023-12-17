package pharmacy.auth.services;

import java.util.List;

// import org.springframework.stereotype.Service;

import pharmacy.auth.entities.Menu;


public interface IMenuService {
    
    public List<Menu> searchMenuByIdMenuParent();
    public List<Menu> searchMenuByIdMenuParentId( Integer id_menu_parent );
    
}
