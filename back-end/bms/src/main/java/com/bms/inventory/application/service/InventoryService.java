package com.bms.inventory.application.service;

import com.bms.inventory.application.dto.BookDTO;
import com.bms.inventory.application.dto.CommentDTO;
import com.bms.inventory.domain.model.Book;
import com.bms.inventory.domain.model.Comment;
import com.bms.inventory.domain.repository.BookRepository;
import com.bms.inventory.domain.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BookAssembler bookAssembler;

    @Autowired
    CommentAssembler commentAssembler;

    public BookDTO getBook(Long id) {

        Book book = bookRepository.findById(id).orElse(null);

        return bookAssembler.toResource(book);
    }

    public List<BookDTO> getBooks() {

        List<Book> books = bookRepository.findAll();

        return bookAssembler.toResources(books);
    }

    public BookDTO addBook(BookDTO bookDTO) {

        Book book = new Book();
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());

        bookRepository.save(book);

        return bookAssembler.toResource(book);
    }

    public BookDTO deleteBook(Long id) {

        Book book = bookRepository.findById(id).orElse(null);

        bookRepository.delete(book);

        return bookAssembler.toResource(book);
    }

    public BookDTO editBook(Long bookId, BookDTO bookDTO) {

        Book book = bookRepository.findById(bookId).orElse(null);
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());

        bookRepository.save(book);

        return bookAssembler.toResource(book);
    }

    public CommentDTO addComment(Long bookId, CommentDTO commentDTO) {

        Book book = bookRepository.findById(bookId).orElse(null);

        Comment comment = new Comment();
        comment.setBook(book);
        comment.setContent(commentDTO.getContent());
        comment.setPostDate(commentDTO.getPostDate());

        commentRepository.save(comment);

        return commentAssembler.toResource(comment);
    }

    public List<CommentDTO> getComments(Long bookId) {

        List<Comment> comments = commentRepository.findAllByBookId(bookId);

        return commentAssembler.toResources(comments);
    }
}
