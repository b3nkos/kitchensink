package com.globallogic.kitchensink.members.infrastructure.adapter.repository;

import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.domain.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryAdapter implements MemberRepository {
    private final MemberJpaRepository memberJpaRepository;

    public MemberRepositoryAdapter(MemberJpaRepository memberJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
    }

    @Override
    public Member save(Member member) {
        MemberEntity entity = toEntity(member);
        MemberEntity save = memberJpaRepository.save(entity);
        return toDomain(save);
    }

    @Override
    public Optional<Member> findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberJpaRepository.findById(id);
        return optionalMemberEntity.map(this::toDomain);

    }

    @Override
    public List<Member> findAll() {
        return memberJpaRepository
                .findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    private MemberEntity toEntity(Member member) {
        return new MemberEntity(
                member.getName(),
                member.getEmail(),
                member.getPhone()
        );
    }

    private Member toDomain(MemberEntity memberEntity) {
        return new Member(
                memberEntity.getId(),
                memberEntity.getName(),
                memberEntity.getEmail(),
                memberEntity.getPhone()
        );
    }
}
