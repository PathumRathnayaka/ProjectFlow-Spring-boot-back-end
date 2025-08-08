package com.project.ProjectFlow.dao;

import com.project.ProjectFlow.entity.impl.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<MemberEntity, String> {
}
