package com.project.ProjectFlow.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CRUDUtil <T>{
    ResponseEntity<T> save(T dto);
    void delete(String id);
    void update(String id, T dto);
    T get(String id);
    List<T> getAll();
}
