package com.globallogic.kitchensink.members.application.usecase;

import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.domain.service.MemberDomainService;

import java.util.List;

public class GetAllMembersUseCase {
    private final MemberDomainService memberDomainService;

    public GetAllMembersUseCase(MemberDomainService memberDomainService) {
        this.memberDomainService = memberDomainService;
    }


    public List<Member> getAllMembers() {
        return memberDomainService.getAllMembers();
    }
}
