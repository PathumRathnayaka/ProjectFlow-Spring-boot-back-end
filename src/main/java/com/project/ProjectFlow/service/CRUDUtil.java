package com.project.ProjectFlow.service;

import com.project.ProjectFlow.customstatuscode.SuccessStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CRUDUtil <T>{
    SuccessStatus save(T dto);
    SuccessStatus delete(String id);
    SuccessStatus update(String id, T dto);
    T get(String id);
    List<T> getAll();

}
