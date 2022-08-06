package site.itseasy.jpabook1.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import site.itseasy.jpabook1.domain.Member;
import site.itseasy.jpabook1.dto.MemberDto;

import static org.modelmapper.convention.MatchingStrategies.STRICT;

public class ModelMapperUtils {

    public static ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(STRICT);

        modelMapper.typeMap(MemberDto.class, Member.class).addMappings(m -> {
        });
        return modelMapper;
    }
}
