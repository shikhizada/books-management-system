package com.bms.inventory.application.dto;

import com.bms.inventory.domain.model.Comment;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

@Data
public class BookDTO extends ResourceSupport {

    Long _id;
    String title;
    String author;
    String isbn;
    List<Comment> comments;
}
