package org.digitalcrafting.theOne.service.outposts.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OutpostsMapper {

    List<OutpostEntity> getAllOutposts();
}
