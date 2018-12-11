package com.test.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStream {

    public static List<Article> getArticleList() {
        String[] tags1 = new String[]{"java", "python", "shell"};
        String[] tags2 = new String[]{"c", "c++", "ruby"};
        String[] tags3 = new String[]{"go", "c#", "java"};
        Article article1 = new Article("group1", "author1", Arrays.asList(tags1));
        Article article2 = new Article("group2", "author1", Arrays.asList(tags2));
        Article article3 = new Article("group3", "author1", Arrays.asList(tags3));
        List<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        return articles;
    }


    public static Optional<Article> getFirstJavaArticle(List<Article> articles) {
/*        public Article getFirstJavaArticle() {
            for (Article article : articles) {
                if (article.getTags().contains("Java")) {
                    return article;
                }
            }
            return null;
        }*/
        return articles.stream()
                .filter(article -> article.getTags().contains("java"))
                .findFirst();
    }

    public static List<Article> getAllJavaArticles(List<Article> articles) {
/*        public List<Article> getAllJavaArticles() {
            List<Article> result = new ArrayList<>();
            for (Article article : articles) {
                if (article.getTags().contains("Java")) {
                    result.add(article);
                }
            }
            return result;
        }*/
        return articles.stream()
                .filter(article -> article.getTags().contains("java"))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Article> articles = getArticleList();
    }
}
