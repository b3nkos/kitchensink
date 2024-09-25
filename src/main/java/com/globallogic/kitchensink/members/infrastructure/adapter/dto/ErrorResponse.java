package com.globallogic.kitchensink.members.infrastructure.adapter.dto;

public record ErrorResponse(int httpCode, String httpCodeMessage, String message) {
}