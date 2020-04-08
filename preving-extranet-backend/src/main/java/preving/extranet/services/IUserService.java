package preving.extranet.services;

import preving.extranet.entities.User;
import preving.extranet.security.model.JwtUser;
import preving.extranet.security.model.Login;

public interface IUserService {
	
	public User checkUserLogin(User user);
	
	public User findById(Long id);
	
	public User findUser(User user);

	public JwtUser existUser(Login login);
	
}