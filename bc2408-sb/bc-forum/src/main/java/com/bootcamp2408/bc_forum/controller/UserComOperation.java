package com.bootcamp2408.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp2408.bc_forum.model.UserCommentDTO;

public interface UserComOperation {
   @GetMapping("/bcf/usercom")
  List<UserCommentDTO> getUserComment();
}
