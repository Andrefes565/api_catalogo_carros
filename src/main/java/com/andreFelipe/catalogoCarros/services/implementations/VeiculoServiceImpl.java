package com.andreFelipe.catalogoCarros.services.implementations;

import com.andreFelipe.catalogoCarros.domain.Veiculo;
import com.andreFelipe.catalogoCarros.model.FilterModel;
import com.andreFelipe.catalogoCarros.model.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.andreFelipe.catalogoCarros.repository.VeiculoRepository;
import com.andreFelipe.catalogoCarros.rest.dtos.VeiculoDTO;
import com.andreFelipe.catalogoCarros.services.abstrations.VeiculoService;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public Veiculo create(VeiculoDTO dto) {
        Veiculo veiculo = new Veiculo();

        veiculo.setMarca(dto.getMarca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setPreco(dto.getPreco());
        veiculo.setQuilometragem(dto.getQuilometragem());
        veiculo.setAno(dto.getAno());
        veiculo.setTransmissao(dto.getTransmissao());
        veiculo.setCarroceria(dto.getCarroceria());
        veiculo.setCombustivel(dto.getCombustivel());
        veiculo.setQtdPortas(dto.getQtdPortas());
        veiculo.setCor(dto.getCor());
        return veiculoRepository.save(veiculo);
    }

    @Override
    public List<Veiculo> listAll() {
        return veiculoRepository.findAll();
    }

    @Override
    public PageModel<Veiculo> listAll(FilterModel filter) {

        Page<Veiculo> veiculoPage =veiculoRepository.findAll(filter.toSpringPageable());
        PageModel<Veiculo> pm = new PageModel<>(veiculoPage);
        return pm;
    }


    @Override
    public Optional<Veiculo> findById(Integer id) {
        return veiculoRepository.findById(id);
    }


}
