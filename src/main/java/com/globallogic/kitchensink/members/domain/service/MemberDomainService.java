package com.globallogic.kitchensink.members.domain.service;

import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.domain.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberDomainService {
    private final MemberRepository memberRepository;

    public MemberDomainService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
