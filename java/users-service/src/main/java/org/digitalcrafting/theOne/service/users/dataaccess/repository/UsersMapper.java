package org.digitalcrafting.theOne.service.users.dataaccess.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    List<UserEntity> getAllUsers();
}
