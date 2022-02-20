package com.andreFelipe.catalogoCarros.builder;

public class ExpressionBuilder<T> {

    Class<T> superClass;

    public ExpressionBuilder(Class<T> superClass) {
        this.superClass = superClass;
    }


}
