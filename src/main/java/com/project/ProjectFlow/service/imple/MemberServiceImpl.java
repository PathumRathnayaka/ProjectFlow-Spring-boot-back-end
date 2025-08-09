package com.project.ProjectFlow.service.imple;

import com.project.ProjectFlow.dto.impl.MemberDto;
import com.project.ProjectFlow.service.MemberService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    @Override
    public ResponseEntity<MemberDto> save(Object dto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(String id, Object dto) {

    }

    @Override
    public Object get(String id) {
        return null;
    }

    @Override
    public List getAll() {
        return List.of();
    }
}
