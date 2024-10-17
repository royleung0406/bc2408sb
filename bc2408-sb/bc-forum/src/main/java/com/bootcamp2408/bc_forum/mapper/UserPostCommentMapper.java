package com.bootcamp2408.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp2408.bc_forum.model.CommentDTO;
import com.bootcamp2408.bc_forum.model.PostDTO;
import com.bootcamp2408.bc_forum.model.UserDTO;
import com.bootcamp2408.bc_forum.model.UserPostCommentDTO;

@Component
public class UserPostCommentMapper {

  public  UserPostCommentDTO map(UserDTO user) {
    return UserPostCommentDTO.builder()//
        .id(user.getId())
        .name(user.getName())//
        .username(user.getUsername())//
        .email(user.getEmail())//
        .phone(user.getPhone())//
        .website(user.getWebsite())//
        .build();
  }

  public  UserPostCommentDTO.PostDTO map(PostDTO post) {
    return UserPostCommentDTO.PostDTO.builder()//
        .id(post.getId())//
        .title(post.getTitle())//
        .body(post.getBody())//
        .build();
  }

  public  UserPostCommentDTO.CommentDTO map(CommentDTO comment) {
    return UserPostCommentDTO.CommentDTO.builder()//
        .id(comment.getId())//
        .name(comment.getName())//
        .email(comment.getEmail())//
        .body(comment.getBody())//
        .build();
  
}
}