package pharmacy.auth.services;

import pharmacy.auth.entities.User;

public interface IUserService {

    public User searchUserById( Integer id_user );
}
