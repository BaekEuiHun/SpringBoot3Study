package com.example.firstproject.service;

import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
  @Autowired ArticleService articleService;

  @Test
  void findAll() {
    // 예상 데이터
    Article a = new Article(1L, "가가가가", "1111");
    Article b = new Article(2L, "나나나나", "2222");
    Article c = new Article(3L, "다다다다", "3333");
    List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));
    // 실제 데이터
    List<Article> articles = articleService.findAll();
    // 비교 및 검증
      assertEquals(expected.toString(), articles.toString());
  }

  @Test
  void show_성공() {
    //예상 데이터
    Long id = 1L;
    Article expected = new Article(id,"가가가가","1111");
    //실제 데이터
    Article article = articleService.show(id);
    //비교 및 검증
    assertEquals(expected.toString(), article.toString());
  }
}
