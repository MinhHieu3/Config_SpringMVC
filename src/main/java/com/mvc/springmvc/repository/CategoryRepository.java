package com.mvc.springmvc.repository;

import com.mvc.springmvc.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.category.id = ?1")
    void deleteProductsByCategoryId(int categoryId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Category c WHERE c.id = ?1")
    void deleteCategoryById(int categoryId);
}
