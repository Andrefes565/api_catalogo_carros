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
    private String equalFilters;
    private String differentFilters;


    public FilterModel(Map<String, String> params) {
        //Se esse map conter a chave limit, vamos por o limite especifico, caso contrario o limite vai ser 10
        this.limit = params.containsKey(LIMIT_KEY) ? Integer.valueOf(params.get((LIMIT_KEY))): DEFAULT_LIMIT;
        //Se esse map conter a chave limit, vamos por o limite especifico, caso contrario o limite vai ser 10
        this.page = params.containsKey(PAGE_KEY) ? Integer.valueOf(params.get(PAGE_KEY)): DEFAULT_PAGE;
        this.sort = params.containsKey(SORT_KEY) ? params.get(SORT_KEY):DEFAULT_SORT;
        this.equalFilters = params.containsKey(EQUAL_FILTERS_KEY) ? params.get(EQUAL_FILTERS_KEY):DEFAULT_EQUAL_FILTERS_KEY;
        //this.differentFilters = params.containsKey(DIFFERENT_FILTERS_KEY) ? params.get(DIFFERENT_FILTERS_KEY):DEFAULT_DIFFERENT_FILTERS_KEY;


    }

    public Pageable toSpringPageable(){

        List<Order>orders = getOrders();
        return PageRequest.of(page, limit, Sort.by(orders));
    }

    public List<EqualFilterModel> getEqualFilters() {
        List<EqualFilterModel> filters = new ArrayList<EqualFilterModel>();

        if(equalFilters == null || equalFilters.trim().isEmpty()){
            return filters;
        }

        String[] filtersParam = equalFilters.split(";");

        for(String param: filtersParam){
            if(param.contains(":")){
                String[] elements = param.split(":");

                if(elements.length == 2){
                    String column = elements[0];
                    String value = elements[1];

                    filters.add(new EqualFilterModel(column, value, ":"));
                }
            }

            if(param.contains("~")){
                String[] elements = param.split("~");

                if(elements.length == 2){
                    String column = elements[0];
                    String value = elements[1];

                    filters.add(new EqualFilterModel(column, value, "~"));
                }
            }

            //Se contém apenas o '>'
            if(param.contains(">") && !param.contains("<")) {
                String[] elements = param.split(">");

                String column = elements[0];
                String value = elements[1];
                filters.add(new EqualFilterModel(column, value,">"));

            }
            //Se contém apenas o '<'
            if(!param.contains(">") && param.contains("<")) {
                String[] elements = param.split("<");

                String column = elements[0];
                String value = elements[1];
                filters.add(new EqualFilterModel(column, value,"<"));

            }
            //Se contém o '<' e '>'
            if(param.contains(">") && param.contains("<")) {
                String[] elements = param.split(">");
                String[] subElements = elements[1].split("<");

                String column = elements[0];
                String lessValue = subElements[0];
                String greaterValue = subElements[1];

                if( Double.valueOf(greaterValue) < Double.valueOf(lessValue)){
                    String aux = greaterValue;
                    greaterValue = lessValue;
                    lessValue = aux;
                }

                filters.add(new EqualFilterModel(column, lessValue, greaterValue, "&"));

            }
        }
        return filters;
    }


    public List<DifferentFilterModel> getDifferentFilters() {
        List<DifferentFilterModel> filters = new ArrayList<DifferentFilterModel>();

        if(differentFilters == null || differentFilters.trim().isEmpty()){
            return  filters;
        }

        String[] filtersParam = differentFilters.split(";");

        for(String param: filtersParam){
            if(param.contains("<")){
                String[] elements = param.split("<");

                if(elements.length == 2){
                    String column = elements[0];
                    Number value = Double.valueOf(elements[1]);

                    filters.add(new DifferentFilterModel(column, value, "<"));
                }
            }
        }
        return filters;
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
