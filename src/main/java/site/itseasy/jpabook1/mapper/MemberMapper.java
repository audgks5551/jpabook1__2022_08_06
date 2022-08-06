package site.itseasy.jpabook1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import site.itseasy.jpabook1.domain.Member;
import site.itseasy.jpabook1.dto.MemberDto;

@Mapper
public interface MemberMapper {
    MemberMapper memberMapper = Mappers.getMapper(MemberMapper.class);

    @Mapping(source = "addressDto", target = "address")
    Member toEntity(MemberDto memberDto);

    @Mapping(source = "address", target = "addressDto")
    MemberDto toDto(Member memberDto);
}
