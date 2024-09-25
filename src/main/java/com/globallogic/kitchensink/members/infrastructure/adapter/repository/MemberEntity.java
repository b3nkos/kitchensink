package com.globallogic.kitchensink.members.infrastructure.adapter.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;

    public MemberEntity(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public MemberEntity() {}

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
