package com.bms.inventory.domain.model;

import lombok.*;
import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue
    Long id;

    LocalDate postDate;
    String content;
}
