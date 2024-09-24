package com.globallogic.kitchensink.members.infrastructure.adapter.rest;

import com.globallogic.kitchensink.members.application.usecase.CreateNewMemberUseCase;
import com.globallogic.kitchensink.members.application.usecase.GetAllMembersUseCase;
import com.globallogic.kitchensink.members.application.usecase.GetMemberByIdUseCase;
import com.globallogic.kitchensink.members.infrastructure.adapter.dto.MemberCreationRequest;
import com.globallogic.kitchensink.members.domain.model.Member;
import com.globallogic.kitchensink.members.infrastructure.adapter.mapper.CustomMemberMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final GetAllMembersUseCase getAllMembersUseCase;
    private final GetMemberByIdUseCase getMemberByIdUseCase;
    private final CreateNewMemberUseCase createNewMemberUseCase;
    private final CustomMemberMapper mapper;

    public MemberController(GetAllMembersUseCase getAllMembersUseCase, GetMemberByIdUseCase getMemberByIdUseCase, CreateNewMemberUseCase createNewMemberUseCase, CustomMemberMapper mapper) {
        this.getAllMembersUseCase = getAllMembersUseCase;
        this.getMemberByIdUseCase = getMemberByIdUseCase;
        this.createNewMemberUseCase = createNewMemberUseCase;
        this.mapper = mapper;
    }


    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(getAllMembersUseCase.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        return ResponseEntity.ok(getMemberByIdUseCase.getMemberById(id));
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody MemberCreationRequest request) {
        Member member = mapper.fromMemberCreationRequestToDomain(request);
        Member saved = createNewMemberUseCase.createNewMember(member);
        URI created = URI.create("/members/" + saved.getId());
        return ResponseEntity.created(created).body(saved);
    }
}
