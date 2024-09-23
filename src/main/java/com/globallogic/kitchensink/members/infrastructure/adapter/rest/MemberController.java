package com.globallogic.kitchensink.members.infrastructure.adapter.rest;

import com.globallogic.kitchensink.members.application.dto.MemberCreationRequest;
import com.globallogic.kitchensink.members.application.port.MemberMapper;
import com.globallogic.kitchensink.members.application.port.MemberUseCase;
import com.globallogic.kitchensink.members.domain.model.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberUseCase memberUseCase;
    private final MemberMapper memberMapper;

    public MemberController(MemberUseCase memberUseCase, MemberMapper memberMapper) {
        this.memberUseCase = memberUseCase;
        this.memberMapper = memberMapper;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberUseCase.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        return ResponseEntity.ok(memberUseCase.getMemberById(id).get());
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody MemberCreationRequest request) {
        Member member = memberMapper.fromMemberCreationRequestToDomain(request);
        Member saved = memberUseCase.createMember(member);
        URI created = URI.create("/members/" + saved.getId());
        return ResponseEntity.created(created).body(saved);
    }
}
