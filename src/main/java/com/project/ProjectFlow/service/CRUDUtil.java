package com.project.ProjectFlow.service;

import com.project.ProjectFlow.customstatuscode.SuccessStatus;
import com.project.ProjectFlow.dto.CustomStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CRUDUtil <T>{
    CustomStatus save(T dto);
    CustomStatus delete(String id);
    CustomStatus update(String id, T dto);
    T get(String id);
    List<T> getAll();

}
