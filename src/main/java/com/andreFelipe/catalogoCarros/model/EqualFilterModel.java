package com.andreFelipe.catalogoCarros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class EqualFilterModel {

    private String column;
    private String value;
    private Boolean isEqual;
}
