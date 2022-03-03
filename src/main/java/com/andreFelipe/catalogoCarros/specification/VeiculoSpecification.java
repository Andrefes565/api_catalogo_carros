package com.andreFelipe.catalogoCarros.specification;

import com.andreFelipe.catalogoCarros.builder.ExpressionBuilder;
import com.andreFelipe.catalogoCarros.domain.Veiculo;
import com.andreFelipe.catalogoCarros.model.DifferentFilterModel;
import com.andreFelipe.catalogoCarros.model.EqualFilterModel;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Expression;


public class VeiculoSpecification {

    public static Specification<Veiculo> equal(EqualFilterModel eq){
        return new Specification<Veiculo>() {

            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<Veiculo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                ExpressionBuilder<Veiculo> expBuilder = new ExpressionBuilder<Veiculo>(Veiculo.class);
                Expression<Veiculo> expression = expBuilder.get(root, eq.getColumn());

                Predicate predicate = null;

                if(root != null) {
                    switch (eq.getSimbol()) {
                        case ":":
                            predicate = cb.equal(expression, eq.getValue1());
                            break;
                        case "~":
                            predicate = cb.notEqual(expression, eq.getValue1());
                            break;
                        case "<":
                            if( eq.getColumn().equals("preco")){
                                cb.le(root.get("preco") ,Double.valueOf( eq.getValue1()));
                            } else if(eq.getColumn().equals("ano")){
                                cb.le(root.get("ano") ,Integer.valueOf( eq.getValue1()));
                            }else if(eq.getColumn().equals("quilometragem")){
                                cb.le(root.get("quilometragem") ,Integer.valueOf( eq.getValue1()));
                            }
                            break;
                        case ">":
                            if( eq.getColumn().equals("preco")){
                                predicate = cb.ge(root.get("preco") ,Double.valueOf( eq.getValue1()));
                            } else if(eq.getColumn().equals("ano")){
                                predicate = cb.ge(root.get("ano") , Integer.parseInt( eq.getValue1()));
                            }else if(eq.getColumn().equals("quilometragem")){
                                predicate = cb.ge(root.get("quilometragem") , Integer.parseInt( eq.getValue1()));
                            }
                            break;
                        case "&":
                            if( eq.getColumn().equals("preco")){
                                predicate = cb.between(root.get("preco") ,Double.valueOf( eq.getValue1()), Double.valueOf(eq.getValue2()) );

                            } else if(eq.getColumn().equals("ano")){
                                predicate = cb.between(root.get("ano") ,Integer.parseInt( eq.getValue1()), Integer.parseInt( eq.getValue2()) );
                            } else if(eq.getColumn().equals("quilometragem")){
                                predicate = cb.between(root.get("quilometragem") ,Integer.parseInt( eq.getValue1()), Integer.parseInt( eq.getValue2()) );
                            }
                            break;
                    }
                }
                return predicate;
            }

        };
    }



}
