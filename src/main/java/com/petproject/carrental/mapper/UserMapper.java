package com.petproject.carrental.mapper;

import com.petproject.carrental.dto.SingUpDTO;
import com.petproject.carrental.dto.UserDTO;
import com.petproject.carrental.models.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDTO dto);
    UserDTO toDto(User user);

    @Mapping(target = "password", ignore = true)
    User singUpToUser(SingUpDTO userDTO);
}
