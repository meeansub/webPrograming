package net.skhu.mapper;

import net.skhu.dto.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    List<Book> findAll();
    Book findOne(int id);
    void update(Book book);
    void insert(Book book);
    void delete(int id);
}
