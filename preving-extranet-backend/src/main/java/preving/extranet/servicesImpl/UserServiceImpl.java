package preving.extranet.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import preving.extranet.dao.IUserDao;
import preving.extranet.entities.User;
import preving.extranet.security.model.JwtUser;
import preving.extranet.security.model.Login;
import preving.extranet.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public User checkUserLogin(User user) {
		return (User) userDao.findByEmailAndPassWord(user.getEmail(), user.getPassWord());
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
		return userDao.findByIdSQL(id);
	}

	@Override
	@Transactional(readOnly = true)
	public User findUser(User user) {
		return userDao.findByEmail(user.getEmail());
	}

	@Override
	public JwtUser existUser(Login login) {
		
		User user = userDao.findByEmailAndPassWord(login.getUser(), login.getPassWord());
		if(user == null)
			return null;
		JwtUser usuarioEncontrado = new JwtUser();
		usuarioEncontrado.setId(user.getId());
		usuarioEncontrado.setUserName(user.getEmail());
		usuarioEncontrado.setRole(user.getRol().getNombreRol());
		return usuarioEncontrado;
		
	}

}
