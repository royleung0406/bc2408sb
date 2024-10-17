package com.bootcamp2408.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp2408.bc_forum.entity.UserEntity;
import com.bootcamp2408.bc_forum.model.UserDTO;

public interface UserOperation {


  @GetMapping("/bcf/users")
  List<UserDTO> getUsers();

  @PostMapping("/bcf/users")
  List<UserEntity> createUsers();

  
  @PutMapping("/bcf/users") // by PK
  UserEntity updateUser(@RequestParam Long id, @RequestBody UserEntity entity);

 
}

