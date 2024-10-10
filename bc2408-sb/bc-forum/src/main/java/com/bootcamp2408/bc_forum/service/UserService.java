package com.bootcamp2408.bc_forum.service;

import com.bootcamp2408.bc_forum.entity.UserEntity;
import com.bootcamp2408.bc_forum.model.UserDTO;
import java.util.List;

public interface UserService {
  List<UserDTO> getUsers();
  List<UserEntity> saveUsers();
  
} 
  

