package pharmacy.auth.services.servicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pharmacy.auth.entities.Menu;
import pharmacy.auth.repositories.IMenuRepository;
import pharmacy.auth.services.IMenuService;

@Service
public class IMenuServiceImpl implements IMenuService {

    @Autowired
    private IMenuRepository menuRepository;

    @Override
    public List<Menu> searchMenuByIdMenuParent() {
        return menuRepository.searchMenuByIdMenuParent();
    }

    @Override
    public List<Menu> searchMenuByIdMenuParentId( Integer id_menu_parent ) {
        return menuRepository.searchMenuByIdMenuParentId( id_menu_parent );
    }

    

    
}
