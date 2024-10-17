package com.bootcamp2408.bc_forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp2408.bc_forum.entity.CommentEntity;


// Hibernate (many PL to many DB products), JPA (java to many DB products)
  // 1. During compile time, the implementation class will be generated for this interface
    // i.e. insert, update, delete, select, etc.
  // 2. Auto-integrate with the diff. product of Database driver (maven dependency)
    // i.e. PostgreSQL we have "distinct on"
  // 3. JPA is java layer for developer to interact with Database/SQL/Tables
@Repository // One of the component for Component Scan
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
  // 1. save(): UserEntity & saveAll()
  // 2. findAll
}

// ! Concept of Hibernate:
  // 1. Hibernate generate ABC.class, which is implementing interface UserRepository
  // ABC.class implement UserRepository