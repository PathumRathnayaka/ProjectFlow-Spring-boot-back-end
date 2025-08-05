package com.project.ProjectFlow.repository;


import com.project.ProjectFlow.entity.UserEntity;
import com.project.ProjectFlow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
