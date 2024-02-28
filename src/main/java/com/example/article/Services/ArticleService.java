package com.example.article.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.article.Models.Article;
import com.example.article.Repositories.ArticleRepository;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllSup(double price) {

        List<Article> articles = articleRepository.findAll();
        List<Article> articlesToReturn = new ArrayList<>();

        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getPrice() > price) {
                articlesToReturn.add(articles.get(i));
            }
        }

        return articlesToReturn;
    }

    public List<Article> deleteArticlesOutOfStock() {
        List<Article> articles = articleRepository.findAll();

        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getQuantityInStock() == 0) {
                articleRepository.deleteById(articles.get(i).getCode());
            }
        }

        return articleRepository.findAll();

    }

    public List<Article> insertArticle(Article article) {
        if (articleRepository.findById(article.getCode()).isPresent()) {
            throw new RuntimeException("Code already exists!");
        }
        articleRepository.save(article);
        return articleRepository.findAll();
    }

}
