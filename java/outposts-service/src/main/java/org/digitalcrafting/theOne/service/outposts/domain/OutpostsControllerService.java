package org.digitalcrafting.theOne.service.outposts.domain;

import lombok.RequiredArgsConstructor;
import org.digitalcrafting.theOne.service.outposts.repository.OutpostEntity;
import org.digitalcrafting.theOne.service.outposts.repository.OutpostsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OutpostsControllerService {
    private final OutpostsMapper mapper;

    public List<OutpostModel> getAllOutposts() {
        List<OutpostEntity> entities = mapper.getAllOutposts();
        return OutpostsConverter.convert(entities);
    }
}
