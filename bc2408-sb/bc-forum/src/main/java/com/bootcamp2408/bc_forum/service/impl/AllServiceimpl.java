package com.bootcamp2408.bc_forum.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp2408.bc_forum.mapper.UserPostCommentMapper;
import com.bootcamp2408.bc_forum.model.CommentDTO;
import com.bootcamp2408.bc_forum.model.PostDTO;
import com.bootcamp2408.bc_forum.model.UserDTO;
import com.bootcamp2408.bc_forum.model.UserPostCommentDTO;
import com.bootcamp2408.bc_forum.service.AllService;
import com.bootcamp2408.bc_forum.service.CommentService;
import com.bootcamp2408.bc_forum.service.PostService;
import com.bootcamp2408.bc_forum.service.UserService;

@Service
public class AllServiceimpl implements AllService {
  @Autowired
  private CommentService commentService;

  @Autowired
  private PostService postService;

  @Autowired
  private UserService userService;

  @Autowired
  private UserPostCommentMapper upcmapper;

  @Override
  public List<UserPostCommentDTO> getAllUserPostComment() {
    List<UserDTO> userlists = this.userService.getUsers();
    List<PostDTO> postlists = this.postService.getPosts();
    List<CommentDTO> commentlists = this.commentService.getComments();

 
    List<UserPostCommentDTO> mapperedUserLists = new ArrayList<>();
    userlists.stream().map(user -> {
      List<UserPostCommentDTO.PostDTO> postLists = new ArrayList<>();
      postlists.stream()
      .filter(p -> p.getId().equals(user.getId()) )
      .map(post -> {
        commentlists.stream()//
           .filter(c -> c.getId().equals(post.getId()))
            .map(comment -> this.upcmapper.map(comment))//
            .collect(Collectors.toList());
        post.setCommentDTO(commentlists);
        System.out.println("222" + post);
        UserPostCommentDTO.PostDTO postDto = this.upcmapper.map(post);
        postLists.add(postDto);
        return postLists;
      })//
          .collect(Collectors.toList());
      UserPostCommentDTO userPostCommentDTO = this.upcmapper.map(user);
      userPostCommentDTO.setPostDTO(postLists);
      mapperedUserLists.add(userPostCommentDTO);
      return userPostCommentDTO;
    }).collect(Collectors.toList());

    return mapperedUserLists;
  }
}
