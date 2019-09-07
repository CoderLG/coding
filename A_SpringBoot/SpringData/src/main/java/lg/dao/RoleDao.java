package lg.dao;

import lg.bean.People;
import lg.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {


}
