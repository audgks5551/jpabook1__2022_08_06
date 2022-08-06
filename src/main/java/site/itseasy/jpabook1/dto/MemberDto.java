package site.itseasy.jpabook1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private Long id;
    private String name;
    private AddressDto addressDto;

    public MemberDto(String name, AddressDto addressDto) {
        this.name = name;
        this.addressDto = addressDto;
    }
}
