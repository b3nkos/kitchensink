package com.globallogic.kitchensink.members.application.usecase;

import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.domain.repository.MemberRepository;
import com.globallogic.kitchensink.members.domain.service.MemberDomainService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringJUnitConfig(classes = {GetAllMembersUseCase.class, MemberDomainService.class})
class GetAllMembersUseCaseTest {

    @MockBean
    private MemberRepository memberRepository;

    @Autowired
    private GetAllMembersUseCase getAllMembersUseCase;

    @Test
    @DisplayName("Should return an empty list when does not exist members")
    void shouldReturnAnEmptyListWhenDoesNotExistMembers() {
        when(memberRepository.findAll()).thenReturn(new ArrayList<>());

        List<Member> allMembers = getAllMembersUseCase.getAllMembers();

        assertThat(allMembers).isEmpty();
    }

    @Test
    @DisplayName("Should return a list of members")
    void shouldReturnAListOfMembers() {
        List<Member> members = List.of(
                new Member(1L, "Alice Johnson", "alice.johnson@example.com", "+1-555-123-4567"),
                new Member(2L, "Bob Smith", "bob.smith@example.com", "+1-555-234-5678"),
                new Member(3L, "Charlie Davis", "charlie.davis@example.com", "+1-555-345-6789"),
                new Member(4L, "Diana Evans", "diana.evans@example.com", "+1-555-456-7890"),
                new Member(5L, "Evan Harris", "evan.harris@example.com", "+1-555-567-8901")

        );
        when(memberRepository.findAll()).thenReturn(members);

        List<Member> allMembers = getAllMembersUseCase.getAllMembers();

        assertThat(allMembers).isNotEmpty();
    }

}