package com.bootcamp2408.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp2408.bc_forum.model.Comment;
import com.bootcamp2408.bc_forum.model.Post;
import com.bootcamp2408.bc_forum.model.User;
import com.bootcamp2408.bc_forum.model.User.Address;
import com.bootcamp2408.bc_forum.model.User.Address.Geo;
import com.bootcamp2408.bc_forum.model.UserPostCommentDTO.AddressDTO;
import com.bootcamp2408.bc_forum.model.UserPostCommentDTO.CompanyDTO;
import com.bootcamp2408.bc_forum.model.UserPostCommentDTO.AddressDTO.GeoDTO;
import com.bootcamp2408.bc_forum.model.User.Company;
import com.bootcamp2408.bc_forum.model.UserPostCommentDTO;


@Component
public class UserPostCommentMapper {

  public AddressDTO mapToDTO( Address address) {
    return AddressDTO.builder()//
        .street(address.getStreet())//
        .suite(address.getSuite())//
        .city(address.getCity())//
        .zipcode(address.getZipcode())//
        .geo(this.mapToDTO(address.getGeo()))//
        .build();
  }

  public GeoDTO mapToDTO(Geo geo) {
    return GeoDTO.builder()//
        .lat(geo.getLat())//
        .lng(geo.getLng())//
        .build();
  }

  public CompanyDTO mapToDTO(Company company) {
    return CompanyDTO.builder()//
        .name(company.getName())//
        .catchPhrase(company.getCatchPhrase())//
        .bs(company.getBs())
        .build();
  }

 


  public  UserPostCommentDTO map(User user) {
    return UserPostCommentDTO.builder()//
        .id(user.getId())
        .name(user.getName())//
        .username(user.getUsername())//
        .email(user.getEmail())//
        .phone(user.getPhone())//
        .website(user.getWebsite())//
        .address(mapToDTO(user.getAddress()))
        .company(mapToDTO(user.getCompany()))
        .build();
  }


  public  UserPostCommentDTO.PostDTO map(Post post) {
    return UserPostCommentDTO.PostDTO.builder()//
        .id(post.getId())//
        .title(post.getTitle())//
        .body(post.getBody())//
        .build();
  }

  public  UserPostCommentDTO.CommentDTO map(Comment comment) {
    return UserPostCommentDTO.CommentDTO.builder()//
        .id(comment.getId())//
        .name(comment.getName())//
        .email(comment.getEmail())//
        .body(comment.getBody())//
        .build();
  
}
}