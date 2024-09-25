package com.globallogic.kitchensink.members.infrastructure.adapter.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record MemberCreationRequest(
        @NotNull
        @Size(min = 1, max = 25, message = "Name size must be between 1 and 25 ")
        @Pattern(regexp = "[^0-9]*", message = "Name must not contain numbers")
        String name,
        @NotNull
        @NotEmpty(message = "Email must not be empty")
        @Email(message = "Email must be a well-formed email address")
        String email,
        @NotNull
        @Size(min = 10, max = 12, message = "Phone number size must be between 10 and 12")
        @Digits(fraction = 0, integer = 12)
        String phone) {
}
