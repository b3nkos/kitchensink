package com.globallogic.kitchensink.members.infrastructure.adapter.mapper;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.infrastructure.adapter.repository.mongodb.MemberDocument;

@Component
public class MemberDocumentMapper {
    public MemberDocument toDocument(Member member) {
        return new MemberDocument(
                Math.abs(UUID.randomUUID().getLeastSignificantBits()),
                member.getName(),
                member.getEmail(),
                member.getPhone()
        );
    }

    public Member toDomain(MemberDocument memberDocument) {
        return new Member(
                memberDocument.getId(),
                memberDocument.getName(),
                memberDocument.getEmail(),
                memberDocument.getPhone()
        );
    }
}
