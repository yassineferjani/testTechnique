package org.example.advising;

import java.time.OffsetDateTime;
import lombok.Builder;

@Builder
public record ApiError(
    OffsetDateTime timestamp, int status, String label, String message, String path) {}
