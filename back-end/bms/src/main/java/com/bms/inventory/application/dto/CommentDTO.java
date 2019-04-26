package com.bms.inventory.application.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDate;

@Data
public class CommentDTO extends ResourceSupport {

    Long _id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate postDate;

    String content;
}
