package org.digitalcrafting.theOne.service.users.dataaccess.repository;

import lombok.Data;

@Data
public class UserEntity {
    private String username;
    private String passwordHash;
    private String firstName;
    private String lastName;
}
