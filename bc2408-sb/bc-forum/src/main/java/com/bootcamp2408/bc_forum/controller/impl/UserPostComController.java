package com.bootcamp2408.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp2408.bc_forum.controller.AllPostAndComOperation;
import com.bootcamp2408.bc_forum.model.UserPostCommentDTO;
import com.bootcamp2408.bc_forum.service.AllService;

@RestController
public class UserPostComController implements AllPostAndComOperation{
 

  @Autowired
  private AllService allService; // Interface

  @Override
  public List<UserPostCommentDTO> getAllUserPostComment(){
    return this.allService.getAllUserPostComment();
  }
}

