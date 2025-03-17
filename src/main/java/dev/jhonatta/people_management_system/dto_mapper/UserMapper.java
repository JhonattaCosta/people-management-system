package dev.jhonatta.people_management_system.dto_mapper;

import dev.jhonatta.people_management_system.model.UserModel;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserModel map(UserDTO userDTO){
        UserModel userModel = new UserModel();

        userModel.setId(userDTO.getId());
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());
        userModel.setAge(userDTO.getAge());
        userModel.setCpf(userDTO.getCpf());
        userModel.setImgUrl(userDTO.getImgUrl());

        return userModel;
    }

    public UserDTO map(UserModel userModel){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setAge(userModel.getAge());
        userDTO.setCpf(userModel.getCpf());
        userDTO.setImgUrl(userModel.getImgUrl());

        return userDTO;

    }
}
