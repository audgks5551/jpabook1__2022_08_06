package site.itseasy.jpabook1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import site.itseasy.jpabook1.domain.item.Album;
import site.itseasy.jpabook1.repository.ItemRepository;

@SpringBootTest
@Transactional
public class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    @Rollback(value = false)
    public void 앨범_저장() {
        Album album = Album.builder()
                .name("좋은날")
                .artist("아이유")
                .stockQuantity(3)
                .price(15000)
                .build();

        Album savedItem = (Album) itemRepository.save(album);

        Assertions.assertThat(savedItem.getArtist()).isEqualTo(album.getArtist());
    }
}
