package com.bootcamp2408.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp2408.bc_forum.controller.UserOperation;
import com.bootcamp2408.bc_forum.entity.UserEntity;
import com.bootcamp2408.bc_forum.model.UserDTO;
import com.bootcamp2408.bc_forum.service.UserService;


@RestController
public class UserController implements UserOperation {
// A new Thread
// JPHController c = get bean from Context
// c.getUsers();

  @Autowired
  private UserService userService; // Interface

  @Override
  public List<UserDTO> getUsers(){
    return this.userService.getUsers();
  }


  @Override
  public List<UserEntity> createUsers(){
    return this.userService.saveUsers();
  }

  
  @Override
  public UserEntity updateUser(Long id, UserEntity entity){
    return this.userService.updateUser(id, entity);
  }

 
}



  