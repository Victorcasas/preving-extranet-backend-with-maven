package preving.extranet.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import preving.extranet.entities.Role;
import preving.extranet.entities.User;

public interface IRoleDao  extends CrudRepository<Role, Long> {
	
}
