package pharmacy.auth.security.services;

import java.util.HashMap;
// import java.util.List;
import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import pharmacy.auth.entities.User;
import pharmacy.auth.repositories.IUserRepository;
import pharmacy.auth.security.entities.AuthCredentials;
import pharmacy.auth.utils.RequestResponse;


@Service
@RequiredArgsConstructor
public class AuthServices {

    private final AuthenticationManager authenticationManager;
    private final JwtServices jwtServices;
    private final IUserRepository userRepository;

    public RequestResponse authenticate( AuthCredentials authCredentials ){        
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authCredentials.getEmail(), authCredentials.getPassword())
            );                                
            User userDetails = userRepository.findOneByEmail( authCredentials.getEmail() ).orElseThrow();   

            // **************GENERATE TOKEN***********
            String jwt = jwtServices.generateToken( addClaims(userDetails), userDetails );

            return new RequestResponse( true, "Acceso al sistema.", jwt );                
        } catch (Exception e) {            
            return new RequestResponse( false, "Las credenciales no coinciden.", null );
        }
    }


    
    private Map<String, Object> addClaims ( User userDetails ){
        Map<String, Object> requestUser = new HashMap<>();
        requestUser.put("user", userDetails);
        // requestUser.put("permissionList", listPermission);
        return requestUser;
    }
    
}














// private List<Permission> getListPermission ( User user ){

//     //TODO: GET ALL PERMISSION FOR TYPE USER
//     List<Permission> listPermission = permissionService.searchPermissionByIdUserType( user.getUserType().getId_user_type() );
    
//     for (Permission p : listPermission) {            
//         List<Menu> listaMenuParentByChild = menuService.searchMenuByIdMenuParentId( p.getMenu().getId_menu() );
//         p.getMenu().setChild(listaMenuParentByChild);       
             
//     }
//     return listPermission;
// }