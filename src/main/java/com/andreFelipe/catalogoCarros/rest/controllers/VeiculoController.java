package com.andreFelipe.catalogoCarros.rest.controllers;

import com.andreFelipe.catalogoCarros.domains.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.andreFelipe.catalogoCarros.rest.dtos.VeiculoDTO;
import com.andreFelipe.catalogoCarros.services.abstrations.VeiculoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private VeiculoService service;

    @Autowired
    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping
    List<Veiculo> listAll(){
        return service.listAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo create(@RequestBody VeiculoDTO dto){
        Veiculo veiculo = service.create(dto);
        return veiculo;
    }

    @GetMapping("{id}")
    public Optional<Veiculo> findById(@PathVariable Integer id){
        return service.findById(id);
    }

}
