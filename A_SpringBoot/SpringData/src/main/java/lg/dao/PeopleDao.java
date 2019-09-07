package lg.dao;

import lg.bean.People;
import lg.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PeopleDao extends JpaRepository<People, Integer> {


}
