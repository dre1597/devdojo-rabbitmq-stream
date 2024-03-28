package org.example.devdojorabbitmqstream.stream_test;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
public record PayloadTest(
    String description
) {
}
