package com.globallogic.kitchensink.members.infrastructure.adapter.repository;

import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.domain.repository.MemberRepository;
import com.globallogic.kitchensink.members.infrastructure.adapter.mapper.MemberJpaEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryAdapter implements MemberRepository {
    private final MemberJpaRepository memberJpaRepository;
    private final MemberJpaEntityMapper mapper;

    public MemberRepositoryAdapter(MemberJpaRepository memberJpaRepository, MemberJpaEntityMapper mapper) {
        this.memberJpaRepository = memberJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Member save(Member member) {
        MemberEntity entity = mapper.toEntity(member);
        MemberEntity save = memberJpaRepository.save(entity);
        return mapper.toDomain(save);
    }

    @Override
    public Optional<Member> findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberJpaRepository.findById(id);
        return optionalMemberEntity.map(mapper::toDomain);

    }

    @Override
    public List<Member> findAll() {
        return memberJpaRepository
                .findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
