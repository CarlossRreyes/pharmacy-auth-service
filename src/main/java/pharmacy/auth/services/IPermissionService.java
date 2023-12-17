package pharmacy.auth.services;

import java.util.List;

// import org.springframework.stereotype.Service;

import pharmacy.auth.entities.Permission;


public interface IPermissionService {

    public List<Permission> searchPermissionByIdUserType( Integer id_user_type );
    
}
