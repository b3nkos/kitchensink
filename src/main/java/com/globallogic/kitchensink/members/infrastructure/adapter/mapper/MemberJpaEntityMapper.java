package com.globallogic.kitchensink.members.infrastructure.adapter.mapper;

import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.infrastructure.adapter.repository.jpa.MemberEntity;
import org.springframework.stereotype.Component;

@Component
public class MemberJpaEntityMapper {
    public MemberEntity toEntity(Member member) {
        return new MemberEntity(
                member.getName(),
                member.getEmail(),
                member.getPhone()
        );
    }

    public Member toDomain(MemberEntity memberEntity) {
        return new Member(
                memberEntity.getId(),
                memberEntity.getName(),
                memberEntity.getEmail(),
                memberEntity.getPhone()
        );
    }
}
