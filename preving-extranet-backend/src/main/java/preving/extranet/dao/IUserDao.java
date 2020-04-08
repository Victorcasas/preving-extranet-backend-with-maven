package preving.extranet.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import preving.extranet.entities.User;



public interface IUserDao extends CrudRepository<User, Long> {
	@Transactional
	public User findByEmail(String email);
	
	@Transactional
	public User findByEmailAndPassWord(String email, String password);
	
	@Query("select u from User u where u.id=?1")
	@Transactional
	public User findByIdSQL(Long id);

}
