package pharmacy.auth.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pharmacy.auth.entities.Permission;
import pharmacy.auth.repositories.IPermissionRepository;
import pharmacy.auth.services.IPermissionService;
@Service
public class IPermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionRepository permissionRepository;

    @Override
    public List<Permission> searchPermissionByIdUserType(Integer id_user_type) {
        return this.permissionRepository.searchPermissionByIdUserType(id_user_type);
    }
    
}
