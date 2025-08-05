package com.project.ProjectFlow.service.imple;

import com.project.ProjectFlow.entity.UserEntity;
import com.project.ProjectFlow.model.User;
import com.project.ProjectFlow.repository.UserRepository;
import com.project.ProjectFlow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void saveUser(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(user.getId() != null ? user.getId() : String.valueOf(System.currentTimeMillis()));
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setAvatar(user.getAvatar());
        userEntity.setRole(user.getRole());
        userEntity.setTeamId(userEntity.getTeamId());
        userEntity.setDepartment(user.getDepartment());
        userEntity.setActive(user.isActive());
        userEntity.setJoinedAt(user.getJoinedAt() != null ? user.getJoinedAt() : LocalDateTime.now());

        userRepository.save(userEntity);
    }
}
