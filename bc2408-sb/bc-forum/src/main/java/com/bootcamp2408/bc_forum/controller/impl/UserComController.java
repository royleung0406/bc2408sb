package com.bootcamp2408.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp2408.bc_forum.controller.UserComOperation;
import com.bootcamp2408.bc_forum.model.UserCommentDTO;
import com.bootcamp2408.bc_forum.service.UserCommentService;

@RestController
public class UserComController implements UserComOperation{
 

  @Autowired
  private UserCommentService userCommentService; // Interface

  @Override
  public List<UserCommentDTO> getUserComment(){
    return this.userCommentService.getUserComment();
  }
}

