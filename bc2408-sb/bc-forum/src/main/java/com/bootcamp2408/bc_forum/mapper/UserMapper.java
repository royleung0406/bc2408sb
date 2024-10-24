package com.bootcamp2408.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp2408.bc_forum.entity.UserEntity;
import com.bootcamp2408.bc_forum.model.User;

// JPHMapper -> object (bean) -> map()
@Component
public class UserMapper {
  // reivse from static method to instance
  public UserEntity map(User userDTO) {
    return UserEntity.builder() //
        .addrLat(userDTO.getAddress().getGeo().getLat()) //
        .addrLng(userDTO.getAddress().getGeo().getLng()) //
        .addrCity(userDTO.getAddress().getCity()) //
        .addrStreet(userDTO.getAddress().getStreet()) //
        .addrSuite(userDTO.getAddress().getSuite()) //
        .addrZipcode(userDTO.getAddress().getZipcode()) //
        .comBs(userDTO.getCompany().getBs()) //
        .comCatchPhrase(userDTO.getCompany().getCatchPhrase()) //
        .comName(userDTO.getCompany().getName()) //
        .name(userDTO.getName()) //
        .username(userDTO.getUsername()) //
        .phone(userDTO.getPhone()) //
        .website(userDTO.getWebsite()) //
        .build();
  }
}