package site.itseasy.jpabook1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import site.itseasy.jpabook1.domain.Item;
import site.itseasy.jpabook1.domain.item.Album;
import site.itseasy.jpabook1.dto.AlbumDto;
import site.itseasy.jpabook1.dto.ItemDto;

import java.util.List;

@Mapper
public interface ItemMapper {
    ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);

    default Item toEntity(ItemDto itemDto) {
        if (itemDto == null) {
            return null;
        } else if (itemDto instanceof AlbumDto) {
            return fromAlbumDto((AlbumDto) itemDto);
        }
        return null;
    }

    default ItemDto toDto(Item item) {
        if (item == null) {
            return null;
        } else if (item instanceof Album) {
            return fromAlbum((Album) item);
        }

        return null;
    }

    List<ItemDto> toListDto(List<Item> items);

    AlbumDto fromAlbum(Album album);

    @Mapping(target = "categories", ignore = true)
    Album fromAlbumDto(AlbumDto albumDto);


}
