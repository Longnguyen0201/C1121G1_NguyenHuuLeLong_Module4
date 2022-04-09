package com.codegym.repositoty;

import com.codegym.model.PassBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPassBookRepository extends JpaRepository<PassBook,Long> {
    @Query(value = "select pass_book.*,customer.name from pass_book\n" +
            "join customer on pass_book.customer_id = customer.id\n" +
            "where customer.name like concat('%',?1,'%') ",nativeQuery = true)
    List<PassBook>findAllByName( String keyword);
}
