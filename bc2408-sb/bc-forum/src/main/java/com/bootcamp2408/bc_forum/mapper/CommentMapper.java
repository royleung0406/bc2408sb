package com.bootcamp2408.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp2408.bc_forum.entity.CommentEntity;
import com.bootcamp2408.bc_forum.model.Comment;

// JPHMapper -> object (bean) -> map()
@Component
public class CommentMapper {
  // reivse from static method to instance
  public CommentEntity map(Comment commentDTO) {
    return CommentEntity.builder() //
        .comment_id(commentDTO.getId()).name(commentDTO.getName())
        .email(commentDTO.getEmail()).body(commentDTO.getBody()).build();
  }
}
