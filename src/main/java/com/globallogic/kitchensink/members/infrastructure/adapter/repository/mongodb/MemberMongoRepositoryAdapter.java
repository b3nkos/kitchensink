package com.globallogic.kitchensink.members.infrastructure.adapter.repository.mongodb;

import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.domain.repository.MemberRepository;
import com.globallogic.kitchensink.members.infrastructure.adapter.mapper.MemberDocumentMapper;

@Primary
@Repository
public class MemberMongoRepositoryAdapter implements MemberRepository {

    private final MemberMongoRepository memberMongoRepository;
    private final MemberDocumentMapper mapper;

    public MemberMongoRepositoryAdapter(MemberMongoRepository memberMongoRepository, MemberDocumentMapper mapper) {
        this.memberMongoRepository = memberMongoRepository;
        this.mapper = mapper;
    }

    @Override
    public Member save(Member member) {
        MemberDocument document = mapper.toDocument(member);
        MemberDocument save = memberMongoRepository.save(document);
        return mapper.toDomain(save);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberMongoRepository
        .findById(id)
        .map(mapper::toDomain);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return memberMongoRepository
        .findByEmail(email)
        .map(mapper::toDomain);
    }

    @Override
    public List<Member> findAll() {
        return memberMongoRepository
        .findAllByOrderByNameAsc()
        .stream()
        .map(mapper::toDomain)
        .toList();
    }
    
}
