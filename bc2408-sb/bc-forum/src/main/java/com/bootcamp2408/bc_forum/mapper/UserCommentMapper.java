package com.bootcamp2408.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp2408.bc_forum.model.Comment;
import com.bootcamp2408.bc_forum.model.User;
import com.bootcamp2408.bc_forum.model.UserCommentDTO;

@Component
public class UserCommentMapper {

  public  UserCommentDTO map(User user) {
    return UserCommentDTO.builder()//
        .id(user.getId())
        .username(user.getUsername())//
        .build();
  }

public  UserCommentDTO.UserComDTO map(Comment comment) {
    return UserCommentDTO.UserComDTO.builder()//
        .id(comment.getId())//
        .name(comment.getName())//
        .email(comment.getEmail())//
        .body(comment.getBody())//
        .build();
}
}
