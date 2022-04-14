package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAllByAuthorContainingOrderByDateOfWriting(String keyWordValue, Pageable pageable);

    Iterable<Blog> findAllByCategory_Name(String keyword);


    @Query(value = "select blog.*,category.name from blog join category on blog.category_id = category.category_id " +
            " where category.name like concat('%',?1,'%');", nativeQuery = true)
    Iterable<Blog> findByNameCategory(String keyword);
}
