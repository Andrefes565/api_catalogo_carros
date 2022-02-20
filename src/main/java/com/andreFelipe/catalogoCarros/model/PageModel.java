package com.andreFelipe.catalogoCarros.model;

import com.andreFelipe.catalogoCarros.domain.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
public class PageModel<T> implements Serializable {

    private static final long SerialVersionUIO = 1L;

    private Long totalElements;
    private Integer currentPage;
    private Integer totalPages;
    private Integer pageSize;
    private List<T> elements;

    public PageModel(Page<T> page) {
        this.elements = page.getContent();
        this.totalElements = page.getTotalElements();
        this.currentPage = page.getNumber();
        this.totalPages = page.getTotalPages();
        this.pageSize = page.getSize();
    }


}
