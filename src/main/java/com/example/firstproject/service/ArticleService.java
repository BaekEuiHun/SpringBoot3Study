package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ArticleService {
  @Autowired private ArticleRepository articleRepository;

  public List<Article> findAll() {
    return articleRepository.findAll();
  }

  public Article show(Long id) {
    return articleRepository.findById(id).orElse(null);
  }

  public Article create(ArticleForm dto) {
    Article article = dto.toEntity();
    if (article.getId() != null) {
      return null;
    }
    return articleRepository.save(article);
  }

  public Article update(Long id, ArticleForm dto) {
    Article article = dto.toEntity();
    Article target = articleRepository.findById(id).orElse(null);

    if (target == null || id != article.getId()) {
      return null;
    }
    target.patch(article);
    Article updated = articleRepository.save(target);
    return updated;
  }

  public Article delete(Long id) {
    Article target = articleRepository.findById(id).orElse(null);
    if (target == null) {
      return null;
    }
    articleRepository.delete(target);
    return target;
  }
}
