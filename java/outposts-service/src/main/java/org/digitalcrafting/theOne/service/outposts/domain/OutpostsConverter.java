package org.digitalcrafting.theOne.service.outposts.domain;

import org.digitalcrafting.theOne.service.outposts.repository.OutpostEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class OutpostsConverter {
    private OutpostsConverter() {
    }

    public static List<OutpostModel> convert(List<OutpostEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new ArrayList<>();
        }

        return entities.stream()
                .map(OutpostsConverter::convert)
                .collect(Collectors.toList());
    }

    public static OutpostModel convert(OutpostEntity entity) {
        OutpostModel model = new OutpostModel();

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setLocation(entity.getLocation());

        return model;
    }
}
