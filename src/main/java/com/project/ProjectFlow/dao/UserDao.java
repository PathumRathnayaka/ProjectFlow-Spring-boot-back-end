package com.project.ProjectFlow.dao;

import com.project.ProjectFlow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, String> {
}
