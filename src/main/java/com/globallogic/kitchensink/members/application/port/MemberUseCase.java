package com.globallogic.kitchensink.members.application.port;

import com.globallogic.kitchensink.members.domain.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberUseCase {
    List<Member> getAllMembers();
    Optional<Member> getMemberById(Long id);
    Member createMember(Member member);
}
