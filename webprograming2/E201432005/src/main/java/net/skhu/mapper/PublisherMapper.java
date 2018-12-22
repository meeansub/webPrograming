package net.skhu.mapper;

import net.skhu.dto.Publisher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PublisherMapper {

    List<Publisher> findAll();


}
