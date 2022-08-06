package site.itseasy.jpabook1.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingInheritanceStrategy;
import site.itseasy.jpabook1.domain.Item;
import site.itseasy.jpabook1.dto.ItemDto;

@MapperConfig(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public interface MapConfig{

    Item toEntity(ItemDto itemDto);
    ItemDto toDto(Item item);

}
