package com.spp.springbootpracticeproject.repository;

import com.spp.springbootpracticeproject.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>
//        QuerydslPredicateExecutor<ArticleComment>
{
}
