package com.spp.springbootpracticeproject.repository;

import com.spp.springbootpracticeproject.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}
