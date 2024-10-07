package com.globallogic.kitchensink.members.infrastructure.adapter.repository.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("members")
public class MemberDocument {
    @Id
    private Long id;
    private String name;
    private String email;
    @Indexed(unique = true)
    private String phone;

    public MemberDocument(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public MemberDocument(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public MemberDocument() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
