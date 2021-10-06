package org.digitalcrafting.theOne.service.users.domain;

import lombok.RequiredArgsConstructor;
import org.digitalcrafting.theOne.service.users.repository.UserEntity;
import org.digitalcrafting.theOne.service.users.repository.UsersMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersControllerService {
    private final UsersMapper usersMapper;

    public List<UserModel> getAllUsers() {
        List<UserEntity> entities = usersMapper.getAllUsers();
        return UsersConverter.convert(entities);
    }
}
