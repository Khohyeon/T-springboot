package shop.mtcoding.blog2.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    public int insert();

    public int updateById(int id);

    public int deleteById(int id);

    public List<User> findAll();

    public User findById(int id);
}