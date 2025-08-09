package com.project.ProjectFlow.service.imple;

import com.project.ProjectFlow.customstatuscode.SuccessStatus;
import com.project.ProjectFlow.dao.MemberDao;
import com.project.ProjectFlow.dto.impl.MemberDto;
import com.project.ProjectFlow.entity.impl.MemberEntity;
import com.project.ProjectFlow.service.MemberService;
import com.project.ProjectFlow.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private Mapping mapping;

    @Override
    public SuccessStatus save(MemberDto dto) {
        MemberEntity memberEntity = mapping.toMemberEntity(dto);
        memberDao.save(memberEntity);
        return new SuccessStatus(HttpStatus.CREATED.value(),"Member saved successfully!");
    }

    @Override
    public SuccessStatus delete(String id) {
        return null;
    }

    @Override
    public SuccessStatus update(String id, MemberDto dto) {
        return null;
    }

    @Override
    public MemberDto get(String id) {
        return null;
    }

    @Override
    public List<MemberDto> getAll() {
        return List.of();
    }





}
