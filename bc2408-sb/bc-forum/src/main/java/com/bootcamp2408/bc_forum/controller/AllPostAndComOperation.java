package com.bootcamp2408.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp2408.bc_forum.model.UserPostCommentDTO;

public interface AllPostAndComOperation {
  @GetMapping("/bcf/all")
  List<UserPostCommentDTO> getAllUserPostComment();

  // @PostMapping("/bcf/all")
  // List<UserEntity> createUsers();
}
