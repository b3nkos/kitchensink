package com.globallogic.kitchensink.members.infrastructure.adapter.repository.mongodb;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMongoRepository extends MongoRepository<MemberDocument, Long> {
    Optional<MemberDocument> findByEmail(String email);
    List<MemberDocument> findAllByOrderByNameAsc();
}
