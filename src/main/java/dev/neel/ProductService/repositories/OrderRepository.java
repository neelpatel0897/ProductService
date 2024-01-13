package dev.neel.ProductService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.neel.ProductService.models.Order;
import java.util.UUID;


public interface OrderRepository extends JpaRepository<Order, UUID>{
    @Override
    <S extends Order> S save(S entity);
}