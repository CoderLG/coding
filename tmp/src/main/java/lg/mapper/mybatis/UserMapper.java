package lg.mapper.mybatis;


import lg.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM USER WHERE NAME=#{name}")
    User findByName(@Param("name") String name);

    @Select("SELECT * FROM USER")
    List<User> findAny();

    @Insert("INSERT INTO USER(NAME,AGE) VALUE(#{name},#{age})")
    int insertUser(@Param("name") String name, @Param("age") Integer age);


    @Update("UPDATE USER  SET NAME = #{name} WHERE ID = #{id}")
    int updateUser(@Param("name") String name, @Param("id") int id);

    @Delete("DELETE FROM USER WHERE ID = #{id}")
    int deleteUser(@Param("id") int id);



}