package com.andreFelipe.catalogoCarros.services.abstrations;

import com.andreFelipe.catalogoCarros.domain.Veiculo;
import com.andreFelipe.catalogoCarros.model.FilterModel;
import com.andreFelipe.catalogoCarros.model.PageModel;
import com.andreFelipe.catalogoCarros.rest.dtos.VeiculoDTO;
import org.springframework.data.domain.Page;

import javax.servlet.http.Part;
import java.util.List;
import java.util.Optional;

public interface VeiculoService {

    Veiculo create(VeiculoDTO dto);
    List<Veiculo> listAll();
    Page<Veiculo> listAll(FilterModel filter);
    Optional<Veiculo> findById(Long id);
   byte[] uploadFotoVeiculo(Optional<Veiculo> veiculo, Part arquivo);

}
