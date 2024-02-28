package com.example.article.Controllers;

import java.util.List;

import com.example.article.Models.Article;
import com.example.article.Services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/sup")
    public ResponseEntity<List<Article>> getAllSup(double price) {
        try {
            List<Article> articles = articleService.getAllSup(price);
            return new ResponseEntity<>(articles, HttpStatus.OK); // 200
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }

    @DeleteMapping("/delete-out-of-stock")
    public ResponseEntity<List<Article>> deleteArticlesOutOfStock() {
        try {
            List<Article> articles = articleService.deleteArticlesOutOfStock();
            return new ResponseEntity<>(articles, HttpStatus.OK); //200
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertArticle(@RequestBody Article article) {
        try {
            List<Article> articles = articleService.insertArticle(article);
            return new ResponseEntity<>(articles, HttpStatus.CREATED); //201
        } catch (Exception e) {
            return ResponseEntity.status(224).body(e.getMessage()); //224
        }
    }
}
