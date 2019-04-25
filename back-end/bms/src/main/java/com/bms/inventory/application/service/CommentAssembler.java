package com.bms.inventory.application.service;

import com.bms.inventory.application.dto.CommentDTO;
import com.bms.inventory.domain.model.Comment;
import com.bms.inventory.rest.InventoryRestController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentAssembler extends ResourceAssemblerSupport<Comment, CommentDTO> {

    public CommentAssembler() {
        super(InventoryRestController.class, CommentDTO.class);
    }

    public CommentDTO toResource(Comment comment) {

        CommentDTO commentDTO = new CommentDTO();
        commentDTO.set_id(comment.getId());
        commentDTO.setBook(comment.getBook());
        commentDTO.setContent(comment.getContent());
        commentDTO.setPostDate(comment.getPostDate());

        return commentDTO;
    }

    public List<CommentDTO> toResources(List<Comment> comments) {

        List<CommentDTO> commentDTOS = new ArrayList<>();

        for (Comment comment: comments) {
            commentDTOS.add(toResource(comment));
        }

        return  commentDTOS;
    }
}
