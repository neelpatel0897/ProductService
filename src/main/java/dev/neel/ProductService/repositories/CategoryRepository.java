package dev.neel.ProductService.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import dev.neel.ProductService.models.Category;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
        @Override
        <S extends Category> S save(S entity);
}