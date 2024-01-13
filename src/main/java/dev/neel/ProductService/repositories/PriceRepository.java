package dev.neel.ProductService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.neel.ProductService.models.Price;
import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
    @Override
    <S extends Price> S save(S entity);
}