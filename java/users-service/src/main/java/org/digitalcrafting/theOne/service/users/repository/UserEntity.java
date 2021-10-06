package org.digitalcrafting.theOne.service.users.repository;

import lombok.Data;

@Data
public class UserEntity {
    private String username;
    private String passwordHash;
    private String firstName;
    private String lastName;
}
