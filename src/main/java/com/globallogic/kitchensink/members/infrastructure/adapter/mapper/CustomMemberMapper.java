package com.globallogic.kitchensink.members.infrastructure.adapter.mapper;

import com.globallogic.kitchensink.members.infrastructure.adapter.dto.MemberCreationRequest;
import com.globallogic.kitchensink.members.infrastructure.adapter.dto.MemberCreationResponse;
import com.globallogic.kitchensink.members.domain.model.Member;
import org.springframework.stereotype.Component;

@Component
public class CustomMemberMapper {
    public Member fromMemberCreationRequestToDomain(MemberCreationRequest memberCreationRequest) {
        return new Member(
                memberCreationRequest.name(),
                memberCreationRequest.email(),
                memberCreationRequest.phone()
        );
    }

    public MemberCreationResponse fromDomainToMemberCreationResponse(Member member) {
        return new MemberCreationResponse(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getPhone()
        );
    }
}
