package org.digitalcrafting.theOne.ui.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserControllerService service;

    @GetMapping("/")
    public String healthCheck() {
        return service.healthCheck();
    }
}
