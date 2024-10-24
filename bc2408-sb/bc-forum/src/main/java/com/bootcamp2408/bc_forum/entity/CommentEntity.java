package com.bootcamp2408.bc_forum.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
// JPA library/ Framework
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Comments")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity implements Serializable {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
  private Integer comment_id;
  private String name;
  private String email;
  @Column(length = 1000)
  private String body;



  @ManyToOne
  @JoinColumn(name = "post_id" , nullable = false)
  private PostEntity post;
}