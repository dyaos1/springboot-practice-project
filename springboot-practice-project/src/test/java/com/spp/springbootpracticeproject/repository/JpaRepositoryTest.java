package com.spp.springbootpracticeproject.repository;

import com.spp.springbootpracticeproject.config.JpaConfig;
import com.spp.springbootpracticeproject.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// @ActiveProfiles("testdb") // 테스트용 db 스펙으로 testdb profile을 사용
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 이걸 안하면 위에서 testdb 쓰라고 해도 자동으로 H2 사용
@DisplayName("JPA연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {
    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository
    ) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void given_when_then() {
        //given


        //when
        List<Article> articles = articleRepository.findAll();

        //then
        assertThat(articles)
                .isNotNull()
                .hasSize(123);
    }

    @DisplayName("insert 테스트")
    @Test
    void given_whenInsert_thenWorkFine() {
        //given
        long previousCount = articleRepository.count();

        //when
        articleRepository.save(Article.of("new Article", "new content", "##AA"));

        //then
        assertThat(articleRepository.count())
                .isNotNull()
                .isEqualTo(previousCount + 1);
    }

    @DisplayName("update 테스트")
    @Test
    void given_whenUpdate_thenWorkFine() {
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashTag = "SpringBoot";
        article.setHashtag(updatedHashTag);

        //when
        Article savedArticle = articleRepository.saveAndFlush(article);

        //then
        assertThat(savedArticle)
                .hasFieldOrPropertyWithValue("hashtag", updatedHashTag);
    }

    @DisplayName("delete 테스트")
    @Test
    void given_whenDelete_thenWorkFine() {
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        Long previousArticleCount = articleRepository.count();
        Long previousArticleCommentCount = articleCommentRepository.count();
        int deletedCommentCount = article.getArticleComments().size();

        //when
        articleRepository.delete(article);

        //then
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount-1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousArticleCommentCount - deletedCommentCount);
    }
}