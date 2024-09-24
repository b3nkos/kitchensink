package com.globallogic.kitchensink.members.application.usecase;

import com.globallogic.kitchensink.members.application.exception.MemberNotFoundException;
import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.domain.service.MemberDomainService;

import java.util.Optional;

public class GetMemberByIdUseCase {
    private final MemberDomainService memberDomainService;

    public GetMemberByIdUseCase(MemberDomainService memberDomainService) {
        this.memberDomainService = memberDomainService;
    }

    public Member getMemberById(Long id) {
        Optional<Member> optionalMember = memberDomainService.getMemberById(id);
        return optionalMember.orElseThrow(() -> new MemberNotFoundException(id));
    }
}
