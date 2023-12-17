package pharmacy.auth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pharmacy.auth.entities.Permission;

public interface IPermissionRepository extends CrudRepository<Permission, Integer> {
    
    @Query("SELECT p FROM Permission p WHERE p.state = 'A' AND p.userType.id_user_type = ?1")
    public List<Permission> searchPermissionByIdUserType( Integer id_user_type );
    
}
