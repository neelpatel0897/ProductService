package dev.neel.ProductService.inheritancedemo.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor_st,Long> {
    @Override
     <S extends Mentor_st> S save(S entity);    
}