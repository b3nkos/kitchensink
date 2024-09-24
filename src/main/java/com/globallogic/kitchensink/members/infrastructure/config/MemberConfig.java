package com.globallogic.kitchensink.members.infrastructure.config;

import com.globallogic.kitchensink.members.application.usecase.CreateNewMemberUseCase;
import com.globallogic.kitchensink.members.application.usecase.GetAllMembersUseCase;
import com.globallogic.kitchensink.members.application.usecase.GetMemberByIdUseCase;
import com.globallogic.kitchensink.members.domain.repository.MemberRepository;
import com.globallogic.kitchensink.members.domain.service.MemberDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    @Bean
    public MemberDomainService memberDomainService(MemberRepository memberRepository) {
        return new MemberDomainService(memberRepository);
    }

    @Bean
    public GetAllMembersUseCase memberUseCase(MemberDomainService memberDomainService) {
        return new GetAllMembersUseCase(memberDomainService);
    }

    @Bean
    public GetMemberByIdUseCase getMemberByIdUseCase(MemberDomainService memberDomainService) {
        return new GetMemberByIdUseCase(memberDomainService);
    }

    @Bean
    public CreateNewMemberUseCase createNewMemberUseCase(MemberDomainService memberDomainService) {
        return new CreateNewMemberUseCase(memberDomainService);
    }
}
