package com.andreFelipe.catalogoCarros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DifferentFilterModel {

    private String column;
    private Number value;
    private String simbol;
}
