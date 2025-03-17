package dev.jhonatta.people_management_system.service;

import dev.jhonatta.people_management_system.dto_mapper.UserDTO;
import dev.jhonatta.people_management_system.dto_mapper.UserMapper;
import dev.jhonatta.people_management_system.model.UserModel;
import dev.jhonatta.people_management_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    //Create User
    public UserDTO createUser(UserDTO userDTO){
        UserModel user = userMapper.map(userDTO);
        user = userRepository.save(user);
        return userMapper.map(user);
    }

    //List Users
    public List<UserDTO> listUsers(){
    List<UserModel> users = userRepository.findAll();
    return users.stream()
            .map(userMapper::map)
            .collect(Collectors.toList());
    }

    //List Users by ID
    public UserDTO listUserById(Long id){
        Optional<UserModel> userById = userRepository.findById(id);
        return userById.map(userMapper::map).orElse(null);
    }

    //Change Users
    public UserDTO updateUser(Long id, UserDTO userDTO){
        Optional<UserModel> userExistingOpt = userRepository.findById(id);
        if(userExistingOpt.isPresent()){
            UserModel userExiting = userExistingOpt.get();

            if(userDTO.getName() != null){
                userExiting.setName(userDTO.getName());
            }
            if(userDTO.getEmail() != null){
                userExiting.setEmail(userDTO.getEmail());
            }
            if(userDTO.getAge() != 0){
                userExiting.setAge(userDTO.getAge());
            }
            if(userDTO.getCpf() != null){
                userExiting.setCpf(userDTO.getCpf());
            }
            if(userDTO.getImgUrl() != null){
                userExiting.setImgUrl(userDTO.getImgUrl());
            }
            //Save user changes
            UserModel userSave = userRepository.save(userExiting);
            return userMapper.map(userSave);
        }
        return null;
    }

    //Delete User
    public void userDeleteById (Long id){
        userRepository.deleteById(id);
    }

    //Constructor
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
}
