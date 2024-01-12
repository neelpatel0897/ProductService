package dev.neel.ProductService.inheritancedemo.singletable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User_st,Long> {
    @Override
    <S extends User_st> S save(S entity);
     
}