package com.spp.springbootpracticeproject.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.spp.springbootpracticeproject.domain.Article}
 */
public record ArticleDto(String title, String content, String hashtag, LocalDateTime createdAt, String createdBy,
                         LocalDateTime updatedAt, String updatedBy) implements Serializable {
}