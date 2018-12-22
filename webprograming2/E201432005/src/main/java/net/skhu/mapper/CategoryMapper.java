package net.skhu.mapper;

import net.skhu.dto.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface CategoryMapper {

    List<Category> findAll();
}
