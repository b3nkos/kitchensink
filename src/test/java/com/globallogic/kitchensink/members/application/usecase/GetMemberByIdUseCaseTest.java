package com.globallogic.kitchensink.members.application.usecase;

import com.globallogic.kitchensink.members.application.exception.MemberNotFoundException;
import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.domain.repository.MemberRepository;
import com.globallogic.kitchensink.members.domain.service.MemberDomainService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@SpringJUnitConfig(classes = {GetMemberByIdUseCase.class, MemberDomainService.class})
class GetMemberByIdUseCaseTest {

    @MockBean
    private MemberRepository memberRepository;

    @Autowired
    private GetMemberByIdUseCase getMemberByIdUseCase;

    @Test
    @DisplayName("Should throw a member not found exception")
    void shouldThrowMemberNotFoundException() {
        Long memberId = 1L;
        when(memberRepository.findById(memberId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> {
            getMemberByIdUseCase.getMemberById(memberId);
        })
                .isInstanceOf(MemberNotFoundException.class)
                .hasMessageContaining("Member with id " + memberId + " not found");
    }

    @Test
    @DisplayName("Should return member by id")
    void shouldReturnMemberById() {
        Long memberId = 1L;
        Member member = new Member(1L, "Alice Johnson", "alice.johnson@example.com", "+1-555-123-4567");
        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));
        Member returnedMember = getMemberByIdUseCase.getMemberById(memberId);
        assertThat(returnedMember).isNotNull();
        assertThat(returnedMember.getId()).usingRecursiveComparison().isEqualTo(memberId);
    }

}