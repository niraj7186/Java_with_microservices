package com.altimetrik.candidate.testapi.mapper;

import com.altimetrik.candidate.testapi.entity.UserDto;
import com.altimetrik.candidate.testapi.entity.UserEntity;

public class UserMapper {

    //convert JPA entity to DTO

    public static UserDto mapToUserDto(UserEntity user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getMonthlySalary(),
                user.getMonthlyExp()
        );
        return userDto;
    }


    //convert DTO to User Entity
    public static UserEntity mapToEntity(UserDto userDto){
        UserEntity user = new UserEntity(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getMonthlySalary(),
                userDto.getMonthlyExp()
        );
        return user;

    }
}
