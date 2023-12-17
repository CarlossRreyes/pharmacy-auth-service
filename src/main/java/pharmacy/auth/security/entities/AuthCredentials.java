package pharmacy.auth.security.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class AuthCredentials {

    private String email;
    private String password;
    
}
