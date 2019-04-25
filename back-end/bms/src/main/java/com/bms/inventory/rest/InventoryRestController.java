package com.bms.inventory.rest;

import com.bms.inventory.application.dto.BookDTO;
import com.bms.inventory.application.dto.CommentDTO;
import com.bms.inventory.application.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
@CrossOrigin
public class InventoryRestController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/books")
    public List<BookDTO> getBooks() {

        return inventoryService.getBooks();
    }

    @GetMapping("/books/{id}")
    public BookDTO getBook(@PathVariable  Long id) {

        return inventoryService.getBook(id);
    }

    @PostMapping(path = "/books")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {

        BookDTO addedBookDTO = inventoryService.addBook(bookDTO);

        return new ResponseEntity<>(addedBookDTO, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookDTO> editBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {

        BookDTO editedBookDTO = inventoryService.editBook(id, bookDTO);

        return new ResponseEntity<>(editedBookDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<BookDTO> editBook(@PathVariable Long id) {

        BookDTO deletedBookDTO = inventoryService.deleteBook(id);

        return new ResponseEntity<>(deletedBookDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/books/{id}/comments")
    public List<CommentDTO> getComments(@PathVariable Long id) {

        return inventoryService.getComments(id);
    }

    @PostMapping(path = "/books/{id}/comments")
    public ResponseEntity<CommentDTO> addComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {

        CommentDTO addedCommentDTO = inventoryService.addComment(id, commentDTO);

        return new ResponseEntity<>(addedCommentDTO, new HttpHeaders(), HttpStatus.CREATED);
    }
}
