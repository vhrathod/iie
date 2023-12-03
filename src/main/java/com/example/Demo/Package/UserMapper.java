package com.example.Demo.Package;

import com.example.Demo.Dto.UserDto;
import com.example.Demo.Entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(target = "id", ignore = true)
    UserEntity dtoToEntity(UserDto userDto);

}

