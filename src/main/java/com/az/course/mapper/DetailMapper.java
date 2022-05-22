package com.az.course.mapper;

import com.az.course.entity.Detail;
import com.az.course.model.dto.DetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DetailMapper {

    DetailMapper INSTANCE = Mappers.getMapper(DetailMapper.class);

    @Mapping(target = "employee",source = "employee")
    DetailDto toDto(Detail detail);
}
