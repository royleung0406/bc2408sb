package com.bootcamp2408.bc_forum.service;

import org.hibernate.mapping.List;
import com.bootcamp2408.bc_forum.entity.UserEntity;
import com.bootcamp2408.bc_forum.model.UserDTO;
import java.util.List;

public interface CommentService {
  List <UserDTO> getUsers();
  List <UserEntity> saveUsers();
  
} 
  

