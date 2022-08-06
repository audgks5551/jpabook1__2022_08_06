package site.itseasy.jpabook1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumDto extends ItemDto {
    private String artist;
    private String etc;

    @Builder
    public AlbumDto(Long id, String name, int price, int stockQuantity, String artist, String etc) {
        super(id, name, price, stockQuantity);
        this.artist = artist;
        this.etc = etc;
    }
}
