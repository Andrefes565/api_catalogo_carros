package com.andreFelipe.catalogoCarros.services.implementations;

import com.andreFelipe.catalogoCarros.domains.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andreFelipe.catalogoCarros.domains.repository.VeiculoRepository;
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

        veiculo.setModelo(dto.getModelo());
        veiculo.setPreco(dto.getPreco());
        veiculo.setQuilometragem(dto.getQuilometragem());
        veiculo.setAno(dto.getAno());
        veiculo.setMarca(dto.getMarca());
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
    public Optional<Veiculo> findById(Integer id) {
        return veiculoRepository.findById(id);
    }


}
