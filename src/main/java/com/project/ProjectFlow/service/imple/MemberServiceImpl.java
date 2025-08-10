package com.project.ProjectFlow.service.imple;

import com.project.ProjectFlow.customstatuscode.ErrorStatus;
import com.project.ProjectFlow.customstatuscode.SuccessStatus;
import com.project.ProjectFlow.dao.MemberDao;
import com.project.ProjectFlow.dto.CustomStatus;
import com.project.ProjectFlow.dto.impl.MemberDto;
import com.project.ProjectFlow.entity.impl.MemberEntity;
import com.project.ProjectFlow.exception.ResourceNotFoundException;
import com.project.ProjectFlow.service.MemberService;
import com.project.ProjectFlow.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private Mapping MemberMapping;

    @Override
    public CustomStatus save(MemberDto dto) {
        MemberEntity memberEntity = MemberMapping.toMemberEntity(dto);
        memberDao.save(memberEntity);
        return new SuccessStatus(HttpStatus.CREATED.value(),"Member saved successfully!");
    }

    @Override
    public CustomStatus delete(String id) {
        MemberEntity memberEntity = memberDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member with ID " + id + " not found"));

        memberDao.delete(memberEntity);
        return new SuccessStatus(HttpStatus.OK.value(), "Member deleted successfully!");
    }

    @Override
    public CustomStatus update(String id, MemberDto dto) {
        MemberEntity memberEntity = memberDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member with ID " + id + " not found"));

        memberEntity.setName(dto.getName());
        memberEntity.setEmail(dto.getEmail());
        memberEntity.setAvatar(dto.getAvatar());
        memberEntity.setRole(dto.getRole());
        memberEntity.setTeamId(dto.getTeamId());
        memberEntity.setDepartment(dto.getDepartment());
        memberEntity.setActive(dto.isActive());
        memberEntity.setJoinedAt(dto.getJoinedAt());

        memberDao.save(memberEntity);
        return new SuccessStatus(HttpStatus.OK.value(), "Member updated successfully!");

    }

    @Override
    public MemberDto get(String id) {
        MemberEntity memberEntity = memberDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member with ID " + id + " not found"));
        return MemberMapping.toMemberDto(memberEntity);
    }

    @Override
    public List<MemberDto> getAll() {
        return MemberMapping.asMemberDtoList(memberDao.findAll());

    }





}
