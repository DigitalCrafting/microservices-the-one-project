package org.digitalcrafting.theOne.ui.user;

import org.springframework.stereotype.Service;

@Service
public class UserControllerService {
    public String healthCheck() {
        return "TheOneUI user api is alive!";
    }
}
