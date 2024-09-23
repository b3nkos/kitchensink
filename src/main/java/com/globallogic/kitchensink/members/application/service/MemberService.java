package com.globallogic.kitchensink.members.application.service;

import com.globallogic.kitchensink.members.application.port.MemberUseCase;
import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.domain.service.MemberDomainService;

import java.util.List;
import java.util.Optional;

public class MemberService implements MemberUseCase {
    private final MemberDomainService memberDomainService;

    public MemberService(MemberDomainService memberDomainService) {
        this.memberDomainService = memberDomainService;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberDomainService.getAllMembers();
    }

    @Override
    public Optional<Member> getMemberById(Long id) {
        return memberDomainService.getMemberById(id);
    }

    @Override
    public Member createMember(Member member) {
        return memberDomainService.save(member);
    }
}
