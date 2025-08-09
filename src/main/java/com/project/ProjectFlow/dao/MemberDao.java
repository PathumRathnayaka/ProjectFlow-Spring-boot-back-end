package com.project.ProjectFlow.dao;

import com.project.ProjectFlow.entity.impl.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends JpaRepository<MemberEntity, String> {
}
