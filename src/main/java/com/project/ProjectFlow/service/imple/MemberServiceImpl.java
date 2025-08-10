package com.project.ProjectFlow.service.imple;

import com.project.ProjectFlow.customstatuscode.ErrorStatus;
import com.project.ProjectFlow.customstatuscode.SuccessStatus;
import com.project.ProjectFlow.dao.MemberDao;
import com.project.ProjectFlow.dto.CustomStatus;
import com.project.ProjectFlow.dto.impl.MemberDto;
import com.project.ProjectFlow.entity.impl.MemberEntity;
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
        Optional<MemberEntity> byId = memberDao.findById(id);
        if (byId.isPresent()) {
            memberDao.deleteById(id);
            return new SuccessStatus(HttpStatus.OK.value(), "Member deleted successfully!");
        } else {
            return new ErrorStatus(HttpStatus.NOT_FOUND.value(), "Member not found!");
        }
    }

    @Override
    public CustomStatus update(String id, MemberDto dto) {
        Optional<MemberEntity> byId = memberDao.findById(id);
        if (byId.isPresent()) {
            MemberEntity memberEntity = byId.get();
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
        } else {
            return new ErrorStatus(HttpStatus.NOT_FOUND.value(), "Member not found!");
        }

    }

    @Override
    public MemberDto get(String id) {
        if (memberDao.existsById(id)){
            MemberEntity referenceById = memberDao.getReferenceById(id);
            MemberDto memberDto = MemberMapping.toMemberDto(referenceById);
            return memberDto;
        }
        return null;
    }

    @Override
    public List<MemberDto> getAll() {
        System.out.println("getall working");
        return MemberMapping.asMemberDtoList(memberDao.findAll());

    }





}
