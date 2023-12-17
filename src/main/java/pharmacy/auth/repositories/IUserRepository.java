package pharmacy.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pharmacy.auth.entities.User;

import java.util.Optional;


public interface IUserRepository extends JpaRepository<User, Long> {


    Optional<User> findOneByEmail( String email );

    // Optional<User> findByUsername(String email);

    // @Query(" SELECT u from User u WHERE u.state = 'A' AND u.id_user = ?1 ")
    // public User searchUserById( Integer id_user );

}
