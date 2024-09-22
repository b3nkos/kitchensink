package com.globallogic.kitchensink.members.application.exception;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(Long id) {
        super("Member with ID " + id + " not found");
    }
}
