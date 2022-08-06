package site.itseasy.jpabook1.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.itseasy.jpabook1.domain.Category;
import site.itseasy.jpabook1.domain.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@DiscriminatorValue("A")
public class Album extends Item {
    private String artist;
    private String etc;

    @Builder
    public Album(
            Long id, String name, int price, int stockQuantity, List<Category> categories, String artist, String etc) {
        super(id, name, price, stockQuantity, categories);
        this.artist = artist;
        this.etc = etc;
    }
}
