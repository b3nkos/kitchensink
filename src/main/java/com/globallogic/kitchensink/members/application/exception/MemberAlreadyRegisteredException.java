package com.globallogic.kitchensink.members.application.exception;

public class MemberAlreadyRegisteredException extends RuntimeException {
    public MemberAlreadyRegisteredException(String email) {
        super("Member with email " + email + " is already registered");
    }
}
