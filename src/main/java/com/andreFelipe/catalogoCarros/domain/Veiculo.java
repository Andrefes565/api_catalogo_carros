package com.andreFelipe.catalogoCarros.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="veiculo")
public class Veiculo implements Serializable {

    private static final long serialVerUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
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
    @Column
    @Lob
    private byte[] foto;
}
