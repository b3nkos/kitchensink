package com.globallogic.kitchensink.members.infrastructure.config;

import com.globallogic.kitchensink.members.application.port.MemberUseCase;
import com.globallogic.kitchensink.members.application.service.MemberService;
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
    public MemberUseCase memberUseCase(MemberDomainService memberDomainService) {
        return new MemberService(memberDomainService);
    }
}
