package com.andreFelipe.catalogoCarros.specification;

import com.andreFelipe.catalogoCarros.builder.ExpressionBuilder;
import com.andreFelipe.catalogoCarros.domain.Veiculo;
import com.andreFelipe.catalogoCarros.model.EqualFilterModel;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class VeiculoSpecification {

    public static Specification<Veiculo> equal(EqualFilterModel eq){
        return new Specification<Veiculo>() {

            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<Veiculo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                ExpressionBuilder<Veiculo> expBuilder = new ExpressionBuilder<Veiculo>(Veiculo.class);
                Expression<Veiculo> expression = expBuilder.get(root, eq.getColumn());

                Predicate predicate = null;

                if(expression != null) {
                    predicate = (eq.getIsEqual() ? cb.equal(expression, eq.getValue()) :
                            cb.notEqual(expression, eq.getValue()));
                }
                return predicate;
            }

        };
    }
}
