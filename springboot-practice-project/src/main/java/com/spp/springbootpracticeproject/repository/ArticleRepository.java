package com.spp.springbootpracticeproject.repository;

import com.spp.springbootpracticeproject.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}