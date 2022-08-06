package site.itseasy.jpabook1.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import site.itseasy.jpabook1.dto.AlbumDto;
import site.itseasy.jpabook1.dto.ItemDto;

import java.util.List;

@SpringBootTest
@Transactional
class ItemServiceTest {
    @Autowired
    ItemService itemService;

    @Test
    public void Album_생성() {
        // given
        AlbumDto albumDto = AlbumDto.builder()
                .name("좋은날")
                .price(15000)
                .stockQuantity(3)
                .artist("아이유")
                .etc("가장 인기있는 곡")
                .build();

        // when
        AlbumDto savedAlbumDto = (AlbumDto) itemService.saveItem(albumDto);

        // then
        Assertions.assertThat(savedAlbumDto).isNotNull();
    }

    @Test
    public void Album_리스트() {
        // given
        AlbumDto albumDto1 = AlbumDto.builder()
                .name("좋은날")
                .price(15000)
                .stockQuantity(3)
                .artist("아이유")
                .etc("가장 인기있는 곡")
                .build();

        AlbumDto albumDto2 = AlbumDto.builder()
                .name("분홍신")
                .price(20000)
                .stockQuantity(5)
                .artist("아이유")
                .etc("1위 차트 달성")
                .build();

        itemService.saveItem(albumDto1);
        itemService.saveItem(albumDto2);

        // when
        List<ItemDto> items = itemService.findItems();

        // then
        Assertions.assertThat(items.size()).isEqualTo(2);
    }
}