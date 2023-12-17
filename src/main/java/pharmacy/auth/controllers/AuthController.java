package pharmacy.auth.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import pharmacy.auth.security.entities.AuthCredentials;
// import pharmacy.auth.security.entities.AuthResponse;
import pharmacy.auth.security.services.AuthServices;
import pharmacy.auth.security.services.JwtServices;
import pharmacy.auth.utils.RequestResponse;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    
    private final AuthServices authServices;
    private final JwtServices jwtServices;
    private final UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthCredentials authCredentials){  
        
        System.out.println("Credentials: " + authCredentials.getEmail());
        RequestResponse authResponse = authServices.authenticate(authCredentials);
        if( !(authResponse.isStatus()) ){
            return new ResponseEntity<RequestResponse>( authResponse, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<RequestResponse>( authResponse, HttpStatus.OK);
    }

    @GetMapping("/checkAuthStatus")
	public ResponseEntity<?> test( @RequestHeader("Authorization") String authotizationHeader ) {              
        String token = authotizationHeader.replace( "Bearer ", "" );
        System.out.println("TOKEN: " + token);
        String username = jwtServices.extractUsername( token );
        UserDetails userDetails = userDetailsService.loadUserByUsername( username );
        if( jwtServices.isTokenValid( token, userDetails ) ){
            return new ResponseEntity<RequestResponse>(new RequestResponse(true, "Acceso al sistema", token), HttpStatus.OK);
        }
        return new ResponseEntity<RequestResponse>(new RequestResponse(false, "Token invalido", null), HttpStatus.UNAUTHORIZED);		
	}
    
}