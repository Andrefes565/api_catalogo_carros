package com.andreFelipe.catalogoCarros.services.abstrations;

import com.andreFelipe.catalogoCarros.domains.model.Veiculo;
import com.andreFelipe.catalogoCarros.rest.dtos.VeiculoDTO;

import java.util.List;
import java.util.Optional;

public interface VeiculoService {

    Veiculo create(VeiculoDTO dto);
    List<Veiculo> listAll();
    Optional<Veiculo> findById(Integer id);

}
