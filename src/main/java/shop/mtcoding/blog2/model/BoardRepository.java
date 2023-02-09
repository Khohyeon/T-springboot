package shop.mtcoding.blog2.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardRepository {
    public int insert(@Param("title") String title, @Param("content") String content);

    public int updateById(int id);

    public int deleteById(int id);

    public List<Board> findAll();

    public Board findById(int id);
}
