package com.globallogic.kitchensink.members.application.usecase;

import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.domain.repository.MemberRepository;
import com.globallogic.kitchensink.members.domain.service.MemberDomainService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringJUnitConfig(classes = {CreateNewMemberUseCase.class, MemberDomainService.class})
class CreateNewMemberUseCaseTest {
    @MockBean
    private MemberRepository memberRepository;

    @Autowired
    private CreateNewMemberUseCase createNewMemberUseCase;

    @Test
    @DisplayName("Should create a new member")
    void shouldCreateNewMember() {
        Member member = new Member("Alice Johnson", "alice.johnson@example.com", "+1-555-123-4567");
        Member expectedMember = new Member(1L, "Alice Johnson", "alice.johnson@example.com", "+1-555-123-4567");

        when(memberRepository.save(member)).thenReturn(member);

        Member actualMember = createNewMemberUseCase.createNewMember(member);
        assertThat(actualMember).isNotNull();
        assertThat(actualMember).usingRecursiveComparison().ignoringFields("id").isEqualTo(expectedMember);
    }
}