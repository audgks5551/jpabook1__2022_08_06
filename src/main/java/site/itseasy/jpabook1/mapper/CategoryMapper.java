package site.itseasy.jpabook1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import site.itseasy.jpabook1.domain.Category;
import site.itseasy.jpabook1.dto.CategoryDto;

import java.util.List;

@Mapper(uses = ItemMapper.class)
public interface CategoryMapper {
    CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "child", ignore = true)
    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);

    List<CategoryDto> toListDto(List<Category> categories);
}
