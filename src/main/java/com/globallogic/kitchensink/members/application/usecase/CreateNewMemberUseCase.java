package com.globallogic.kitchensink.members.application.usecase;

import com.globallogic.kitchensink.members.application.exception.MemberAlreadyRegisteredException;
import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.domain.service.MemberDomainService;

import java.util.Optional;

public class CreateNewMemberUseCase {
    private final MemberDomainService memberDomainService;

    public CreateNewMemberUseCase(MemberDomainService memberDomainService) {
        this.memberDomainService = memberDomainService;
    }

    public Member createNewMember(Member member) {
        Optional<Member> optionalMember = memberDomainService.getMemberByEmail(member.getEmail());

        if (optionalMember.isPresent()) {
            throw new MemberAlreadyRegisteredException(member.getEmail());
        }
        return memberDomainService.save(member);
    }
}
