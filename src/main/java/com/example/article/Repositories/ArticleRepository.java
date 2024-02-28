package com.example.article.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.article.Models.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    //List<Article> findByPriceGreaterThan(double price);

}
