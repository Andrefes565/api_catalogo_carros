package com.andreFelipe.catalogoCarros.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.andreFelipe.catalogoCarros.constants.ApiConstants.*;

@Getter
@Setter
public class FilterModel {

    private Integer limit;
    private Integer page;
    private String sort;

    public FilterModel(Map<String, String> params) {
        //Se esse map conter a chave limit, vamos por o limite especifico, caso contrario o limite vai ser 10
        this.limit = params.containsKey(LIMIT_KEY) ? Integer.valueOf(params.get((LIMIT_KEY))): DEFAULT_LIMIT;

        //Se esse map conter a chave limit, vamos por o limite especifico, caso contrario o limite vai ser 10
        this.page = params.containsKey(PAGE_KEY) ? Integer.valueOf(params.get(PAGE_KEY)): DEFAULT_PAGE;

        this.sort = params.containsKey(SORT_KEY) ? params.get(SORT_KEY):DEFAULT_SORT;

    }

    public Pageable toSpringPageable(){

        List<Order>orders = getOrders();
        return PageRequest.of(page, limit, Sort.by(orders));
    }

    private List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        String[] properties = sort.split(",");

        for(String property: properties){
            if(!property.trim().isEmpty()){
                String column = "";

                if(property.startsWith("-")){
                    column = property.replace("-", "").trim();
                    orders.add(Order.desc(column));
                } else {
                    column = property.trim();
                    orders.add(Order.asc(column));
                }
            }
        }
        return orders;
    }

}
