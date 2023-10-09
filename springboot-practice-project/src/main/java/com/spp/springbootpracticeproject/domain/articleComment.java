package com.spp.springbootpracticeproject.domain;

import java.time.LocalDateTime;

public class articleComment {
    private Long id;
    private String content;

    // metadata
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

}
