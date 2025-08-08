package com.project.ProjectFlow.service.imple;

import com.project.ProjectFlow.dto.UserDto;
import com.project.ProjectFlow.model.User;
import com.project.ProjectFlow.repository.UserRepository;
import com.project.ProjectFlow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public ResponseEntity<User> saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setDepartment(userDto.getDepartment());
        User save = userRepository.save(user);
        if (save==null){
            throw new RuntimeException("User not save");
        }else {
            return ResponseEntity.ok(user);
        }
    }

    @Override
    public ResponseEntity<List<User>> getUserAll() {
        List<User> all = userRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @Override
    public ResponseEntity<User> getUserById(String id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()){
            return ResponseEntity.ok(byId.get());
        }else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public ResponseEntity<User> updateUser(String id, UserDto userDto) {

        if (id==null){
            throw new RuntimeException("User Id required");
        }else {
            Optional<User> byId = userRepository.findById(id);
            if (byId.isPresent()){
                User userobj=new User();
                userobj.setName(userDto.getName());
                userobj.setEmail(userDto.getEmail());
                userobj.setAvatar(userobj.getAvatar());
                userobj.setRole(userDto.getRole());
                userobj.setTeamId(userobj.getTeamId());
                userobj.setDepartment(userDto.getDepartment());
                userobj.setActive(userDto.isActive());

                User save = userRepository.save(userobj);
                return ResponseEntity.ok(save);

            }else {
                throw new RuntimeException("Data not Found");
            }
        }
    }

    @Override
    public ResponseEntity<String> deleteUser(String id) {
        if (id==null){
            throw new RuntimeException("User id required");
        }else {
            Optional<User> byId = userRepository.findById(id);
            if (byId.isPresent()){
                userRepository.deleteById(id);
                return ResponseEntity.ok("User deleted");
            }else {
                throw  new RuntimeException("Data not found");
            }
        }
    }


}
