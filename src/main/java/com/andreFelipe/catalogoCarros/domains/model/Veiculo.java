package com.andreFelipe.catalogoCarros.domains.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "preco", precision = 20, scale = 2)
    private Double preco;
    @Column(name = "quilometragem")
    private String quilometragem;
    @Column(name = "marca")
    private String marca;
    @Column(name = "ano")
    private String ano;
    @Column(name = "transmissao")
    private String transmissao;
    @Column(name = "combustivel")
    private String combustivel;
    @Column(name = "carroceria")
    private String carroceria;
    @Column(name = "qtdPortas")
    private Integer qtdPortas;
    @Column(name = "cor")
    private String cor;
}
