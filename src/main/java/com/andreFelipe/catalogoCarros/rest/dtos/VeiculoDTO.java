package com.andreFelipe.catalogoCarros.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {

    private String modelo;
    private String marca;
    private Double preco;
    private Integer quilometragem;
    private Integer ano;
    private String transmissao;
    private String combustivel;
    private String carroceria;
    private Integer qtdPortas;
    private String cor;

}
