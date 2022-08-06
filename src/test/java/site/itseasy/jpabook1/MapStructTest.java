package site.itseasy.jpabook1;

import org.junit.jupiter.api.Test;
import site.itseasy.jpabook1.domain.Address;
import site.itseasy.jpabook1.domain.Member;
import site.itseasy.jpabook1.dto.MemberDto;
import site.itseasy.jpabook1.mapper.MemberMapper;

public class MapStructTest {
    @Test
    public void map_struct_테스트() {

        Member member = Member.builder()
                .id(1L)
                .name("testName")
                .address(
                        Address.builder()
                                .city("대전")
                                .street("석봉동")
                                .build()
                )
                .build();

        // Entity -> DTO
        MemberDto memberDto = MemberMapper.memberMapper.toDto(member);
        // DTO -> Entity, Setter가 없어도 @Builder가 붙어있다면 변환 가능
        Member member1 = MemberMapper.memberMapper.toEntity(memberDto);

        System.out.println(memberDto.getId());
        System.out.println(member.getId());
    }
}
