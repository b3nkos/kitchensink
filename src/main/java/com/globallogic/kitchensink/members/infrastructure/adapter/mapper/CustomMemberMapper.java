package com.globallogic.kitchensink.members.infrastructure.adapter.mapper;

import com.globallogic.kitchensink.members.application.dto.MemberCreationRequest;
import com.globallogic.kitchensink.members.application.dto.MemberCreationResponse;
import com.globallogic.kitchensink.members.application.port.MemberMapper;
import com.globallogic.kitchensink.members.domain.model.Member;
import org.springframework.stereotype.Component;

@Component
public class CustomMemberMapper implements MemberMapper {
    @Override
    public Member fromMemberCreationRequestToDomain(MemberCreationRequest memberCreationRequest) {
        return new Member(
                memberCreationRequest.name(),
                memberCreationRequest.email(),
                memberCreationRequest.phone()
        );
    }

    @Override
    public MemberCreationResponse fromDomainToMemberCreationResponse(Member member) {
        return new MemberCreationResponse(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getPhone()
        );
    }
}
