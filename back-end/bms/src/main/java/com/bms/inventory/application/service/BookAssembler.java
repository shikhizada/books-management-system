package com.bms.inventory.application.service;

import com.bms.inventory.application.dto.BookDTO;
import com.bms.inventory.domain.model.Book;
import com.bms.inventory.rest.InventoryRestController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookAssembler extends ResourceAssemblerSupport<Book, BookDTO> {

    public BookAssembler() {
        super(InventoryRestController.class, BookDTO.class);
    }

    public BookDTO toResource(Book book) {

        BookDTO bookDTO = new BookDTO();
        bookDTO.set_id(book.getId());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setTitle(book.getTitle());

        return  bookDTO;
    }

    public List<BookDTO> toResources(List<Book> books) {

        List<BookDTO> bookDTOS = new ArrayList<>();

        for (Book book: books) {
            bookDTOS.add(toResource(book));
        }

        return  bookDTOS;
    }
}
