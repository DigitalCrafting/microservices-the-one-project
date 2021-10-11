package org.digitalcrafting.theOne.service.users.domain;

import org.digitalcrafting.theOne.service.users.dataaccess.repository.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class UsersConverter {
    private UsersConverter() {
    }

    public static List<UserModel> convert(List<UserEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new ArrayList<>();
        }

        return entities.stream()
                .map(UsersConverter::convert)
                .collect(Collectors.toList());
    }

    public static UserModel convert(UserEntity entity) {
        UserModel model = new UserModel();

        model.setUsername(entity.getUsername());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());

        return model;
    }
}