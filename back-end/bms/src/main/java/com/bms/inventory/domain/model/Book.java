package com.bms.inventory.domain.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    Long id;

    String title;
    String author;
    String isbn;
}
