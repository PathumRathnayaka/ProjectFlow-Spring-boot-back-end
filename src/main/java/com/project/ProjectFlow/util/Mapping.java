package com.project.ProjectFlow.util;

import com.project.ProjectFlow.dto.impl.MemberDto;
import com.project.ProjectFlow.entity.impl.MemberEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;


    // for Member Mapping
    public MemberEntity toMemberEntity (MemberDto memberDto){
        return modelMapper.map(memberDto, MemberEntity.class);
    }
    public MemberDto toMemberDto (MemberEntity memberEntity){
        return modelMapper.map(memberEntity, MemberDto.class);
    }
    public List<MemberDto> asMemberDtoList(List<MemberEntity> memberEntityList){
        return modelMapper.map(memberEntityList, new TypeToken<List<MemberDto>>(){}.getType());
    }
}
