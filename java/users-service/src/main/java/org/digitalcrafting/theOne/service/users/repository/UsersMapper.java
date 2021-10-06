package org.digitalcrafting.theOne.service.users.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {
    List<UserEntity> getAllUsers();
}
