package com.globallogic.kitchensink.members.application.port;

import com.globallogic.kitchensink.members.application.dto.MemberCreationRequest;
import com.globallogic.kitchensink.members.application.dto.MemberCreationResponse;
import com.globallogic.kitchensink.members.domain.model.Member;

public interface MemberMapper {
    public Member fromMemberCreationRequestToDomain(MemberCreationRequest memberCreationRequest);
    public MemberCreationResponse fromDomainToMemberCreationResponse(Member member);
}
