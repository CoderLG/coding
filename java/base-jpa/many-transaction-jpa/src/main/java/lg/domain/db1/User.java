package lg.domain.db1;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data            //n对多的时候 不用lombok
@Table(name="t_user")
public class User {

	@Id
	private Integer userId;

	private String name;


}
