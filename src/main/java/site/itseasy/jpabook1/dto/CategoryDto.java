package site.itseasy.jpabook1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String name;
    private CategoryDto parent;
    private List<ItemDto> items;
}
