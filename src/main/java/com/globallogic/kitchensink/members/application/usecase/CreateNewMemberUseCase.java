package com.globallogic.kitchensink.members.application.usecase;

import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.domain.service.MemberDomainService;

public class CreateNewMemberUseCase {
    private final MemberDomainService memberDomainService;

    public CreateNewMemberUseCase(MemberDomainService memberDomainService) {
        this.memberDomainService = memberDomainService;
    }

    public Member createNewMember(Member member) {
        return memberDomainService.save(member);
    }
}
