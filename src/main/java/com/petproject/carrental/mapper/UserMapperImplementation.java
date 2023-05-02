package com.petproject.carrental.mapper;

import com.petproject.carrental.dto.SingUpDTO;
import com.petproject.carrental.dto.UserDTO;
import com.petproject.carrental.models.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImplementation implements UserMapper {

    @Override
    public User toUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setId(userDTO.getId());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setPassportNumber(userDTO.getPassportNumber());

        return user;
    }

    @Override
    public UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setPassportNumber(user.getPassportNumber());

        return userDTO;
    }

    @Override
    public User singUpToUser(SingUpDTO userDTO) {
        return null;
    }
}
