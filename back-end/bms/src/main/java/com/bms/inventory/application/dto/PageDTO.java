package com.bms.inventory.application.dto;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

@Data
public class PageDTO<T> extends ResourceSupport {

    int page;
    int limit;
    int totalPages;
    long totalElements;
    List<T> elements;
}

