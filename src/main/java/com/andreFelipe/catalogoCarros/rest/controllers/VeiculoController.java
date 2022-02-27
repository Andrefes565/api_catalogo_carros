package com.andreFelipe.catalogoCarros.rest.controllers;

import com.andreFelipe.catalogoCarros.domain.Veiculo;
import com.andreFelipe.catalogoCarros.model.FilterModel;
import com.andreFelipe.catalogoCarros.model.PageModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.andreFelipe.catalogoCarros.rest.dtos.VeiculoDTO;
import com.andreFelipe.catalogoCarros.services.abstrations.VeiculoService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin("*")
public class VeiculoController {

    private VeiculoService service;

    @Autowired
    public VeiculoController(VeiculoService service) {
        this.service = service;
    }


    @GetMapping
    public Page<Veiculo> listAll(@RequestParam Map<String, String> params){
        FilterModel filter = new FilterModel(params);
        Page<Veiculo> veiculoPage = service.listAll(filter);
        return veiculoPage;
    }

    /*
    @GetMapping
    public PageModel<Veiculo> listAll(@RequestParam Map<String, String> params){
        FilterModel filter = new FilterModel(params);
        PageModel<Veiculo> pm = service.listAll(filter);
        return pm;
    }
    */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo create(@RequestBody VeiculoDTO dto){
        Veiculo veiculo = service.create(dto);
        return veiculo;
    }

    @GetMapping("{id}")
    public Optional<Veiculo> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("{id}/foto")
    public byte[]addPhoto() {

    }

}
