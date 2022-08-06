package site.itseasy.jpabook1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ItemDto {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
}
