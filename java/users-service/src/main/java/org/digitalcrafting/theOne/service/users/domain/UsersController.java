package org.digitalcrafting.theOne.service.users.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/v1")
public class UsersController {

    private final UsersControllerService service;

    @GetMapping("/")
    public List<UserModel> getUsersList() {
        return service.getAllUsers();
    }
}
