package com.andreFelipe.catalogoCarros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class EqualFilterModel {

    private String column;
    private String value1;
    private String value2;
    private String simbol;

    public EqualFilterModel(String column, String value1, String value2, String simbol) {
        this.column = column;
        this.value1 = value1;
        this.value2 = value2;
        this.simbol = simbol;
    }

    public EqualFilterModel(String column, String value1, String simbol) {
        this.column = column;
        this.value1 = value1;
        this.simbol = simbol;
    }
}
