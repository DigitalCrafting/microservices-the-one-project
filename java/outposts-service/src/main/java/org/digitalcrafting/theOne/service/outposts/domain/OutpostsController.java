package org.digitalcrafting.theOne.service.outposts.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/outposts/v1")
public class OutpostsController {

    private final OutpostsControllerService service;

    @GetMapping("/")
    public List<OutpostModel> getAllOutposts() {
        return service.getAllOutposts();
    }
}
