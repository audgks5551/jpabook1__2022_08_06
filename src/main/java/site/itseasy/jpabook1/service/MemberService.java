package site.itseasy.jpabook1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.itseasy.jpabook1.domain.Member;
import site.itseasy.jpabook1.dto.MemberDto;
import site.itseasy.jpabook1.repository.MemberRepository;

import java.util.List;

import static site.itseasy.jpabook1.mapper.MemberMapper.memberMapper;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(MemberDto memberDto) {
        Member member = memberMapper.toEntity(memberDto);

        validateDuplicateMember(member);

        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }
}
