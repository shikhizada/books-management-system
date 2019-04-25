package com.bms.inventory.application.dto;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
public class BookDTO extends ResourceSupport {

    Long _id;
    String title;
    String author;
    String isbn;
}
