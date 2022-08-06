package site.itseasy.jpabook1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import site.itseasy.jpabook1.domain.Member;
import site.itseasy.jpabook1.dto.AddressDto;
import site.itseasy.jpabook1.dto.MemberDto;
import site.itseasy.jpabook1.mapper.MemberMapper;
import site.itseasy.jpabook1.repository.MemberRepository;
import site.itseasy.jpabook1.service.MemberService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() {
        // given
        MemberDto memberDto = new MemberDto("user1", new AddressDto("대전광역시", "석봉동"));

        // when
        Long joinId = memberService.join(memberDto);
        Member joinMember = memberService.findOne(joinId);

        // then
        assertThat(joinMember.getId()).isNotNull();
        assertThat(joinMember.getName()).isEqualTo(memberDto.getName());
        assertThat(joinMember.getAddress().getCity()).isEqualTo(memberDto.getAddressDto().getCity());
        assertThat(joinMember.getAddress().getStreet()).isEqualTo(memberDto.getAddressDto().getStreet());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Long joinId = memberService.join(new MemberDto("user1", new AddressDto("대전광역시", "석봉동")));
        Member joinMember = memberService.findOne(joinId);
        MemberDto memberDto = MemberMapper.memberMapper.toDto(joinMember);

        // when
        // then
        assertThrows(IllegalStateException.class, () -> memberService.join(memberDto));
    }

    @Test
    public void 회원_모두_조회() {
        // given
        memberService.join(new MemberDto("user1", new AddressDto("대전광역시", "길거리1")));
        memberService.join(new MemberDto("user2", new AddressDto("서울광역시", "길거리2")));
        memberService.join(new MemberDto("user3", new AddressDto("부산", "길거리3")));

        // when
        List<Member> members = memberService.findMembers();

        // then
        Assertions.assertThat(members.size()).isEqualTo(3);
    }
}