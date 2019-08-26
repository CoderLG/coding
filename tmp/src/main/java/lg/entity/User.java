package lg.entity;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table
public class User {
    private int id;
    private String name;
    private Integer age;
}
