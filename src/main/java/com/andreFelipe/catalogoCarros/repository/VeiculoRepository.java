package com.andreFelipe.catalogoCarros.repository;

import com.andreFelipe.catalogoCarros.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Optional<Veiculo> findById(Integer id);
}
