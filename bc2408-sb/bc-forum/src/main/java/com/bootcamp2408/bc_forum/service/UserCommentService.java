package com.bootcamp2408.bc_forum.service;

import java.util.List;
import com.bootcamp2408.bc_forum.model.UserCommentDTO;

public interface UserCommentService {
  
  List<UserCommentDTO> getUserComment();
}
