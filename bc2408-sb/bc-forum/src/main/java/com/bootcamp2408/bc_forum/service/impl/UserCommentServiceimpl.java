package com.bootcamp2408.bc_forum.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp2408.bc_forum.mapper.UserCommentMapper;
import com.bootcamp2408.bc_forum.model.Comment;
import com.bootcamp2408.bc_forum.model.Post;
import com.bootcamp2408.bc_forum.model.User;
import com.bootcamp2408.bc_forum.model.UserCommentDTO;
import com.bootcamp2408.bc_forum.model.UserCommentDTO.UserComDTO;
import com.bootcamp2408.bc_forum.service.CommentService;
import com.bootcamp2408.bc_forum.service.PostService;
import com.bootcamp2408.bc_forum.service.UserCommentService;
import com.bootcamp2408.bc_forum.service.UserService;

@Service
public class UserCommentServiceimpl implements UserCommentService {
  @Autowired
  private CommentService commentService;

  @Autowired
  private PostService postService;

  @Autowired
  private UserService userService;

  @Autowired
  private UserCommentMapper ucmapper;

  @Override
  public List<UserCommentDTO> getUserComment() {
    List<User> userlists = this.userService.getUsers();
    List<Post> postlists = this.postService.getPosts();
    List<Comment> commentlists = this.commentService.getComments();


    List<UserCommentDTO> ans = new ArrayList<>();
    for (int i = 0; i < userlists.size(); i++) {
      for (int j = 0; j < postlists.size(); j++) {
        if (userlists.get(i).getId().equals(postlists.get(j).getUserId())) {
          for (int k = 0; k < commentlists.size(); k++) {
            if (postlists.get(j).getId()
                .equals(commentlists.get(k).getPostId())) {
              UserCommentDTO userCommentObj = UserCommentDTO.builder()//
                  .id(userlists.get(i).getId())//
                  .username(userlists.get(i).getUsername())//
                  .build();
              List<UserComDTO> result = new ArrayList<>();
              UserComDTO targetComment = ucmapper.map(commentlists.get(k));
              result.add(targetComment);
              userCommentObj.setCommentDTO(result);
              ans.add(userCommentObj);
            }
          }
        }

      }
    }
    return ans;



  //   //  @Override
  // public UserCommentDTO getUserCommentDTO(String userID) {
  //   Integer convertUserID = Integer.parseInt(userID);
  //   List<UserPostCommentDTO> allList = userPostCommentDTOService.getUserPostCommentDTO();
  //   UserCommentDTO result = new UserCommentDTO();

  //   // Find the user by ID using stream
  //   UserPostCommentDTO targetUser = allList.stream()
  //       .filter(user -> convertUserID.equals(user.getId()))
  //       .findFirst()
  //       .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));

  //   // Collect all comments from all posts using stream
  //   List<UserCommentDTO.CommentDTO> insideList = targetUser.getPostDTO().stream()
  //       .flatMap(post -> post.getCommentDTO().stream())  // Flatten the comments from all posts 
  //       .map(comment -> userPostCommentMapper.map(comment))  // Map each comment to UserCommentDTO.CommentDTO
  //       .collect(Collectors.toList());

  //   // Set result data
  //   result.setId(convertUserID);
  //   result.setName(targetUser.getName());
  //   result.setCommentDTOs(insideList);

  //   return result;

  }
}
