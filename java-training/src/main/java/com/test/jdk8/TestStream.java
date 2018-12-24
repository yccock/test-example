package com.test.jdk8;

import com.google.common.collect.ComparisonChain;

import java.util.*;
import java.util.stream.Collectors;

public class TestStream {

    public static List<Article> getArticleList() {
        Date date = new Date();
        String[] tags1 = new String[]{"java", "python", "shell"};
        String[] tags2 = new String[]{"c", "c++", "ruby"};
        String[] tags3 = new String[]{"go", "c#", "java"};
        Article article1 = new Article(1,"group1", "author1", Arrays.asList(tags1), date);
        Article article2 = new Article(2,"group2", "author2", Arrays.asList(tags2), new Date(date.getTime() + 2000));
        Article article3 = new Article(3,"group3", "author3", Arrays.asList(tags3), new Date(date.getTime() + 6000));
        Article article4 = new Article(1,"group1", "author1", Arrays.asList(tags3), new Date(date.getTime() + 3000));
        Article article5 = new Article(5,"group5", "author5", Arrays.asList(tags3), new Date(date.getTime() - 3000));
        List<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
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


    public static List<Article> sortByPublishDate(List<Article> articles) {
        //按日期降序排列
        return articles.stream()
                .sorted(Comparator.comparing(Article::getPublishDate).reversed())
                .collect(Collectors.toList());
    }

    //先按id再按时间倒序排列
    public static void sortByIdAndPublishDate(List<Article> articleList){
        Collections.sort(articleList, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return ComparisonChain.start()
                        .compare(o2.getId(), o1.getId())
                        .compare(o2.getPublishDate(), o1.getPublishDate())
                        .result();
            }
        });
    }
    public static void main(String[] args) {
        List<Article> articles = sortByPublishDate(getArticleList());
        for (Article article : articles) {
            System.out.println(article);
        }

        System.out.println("===============");
        sortByIdAndPublishDate(articles);
        for (Article article : articles) {
            System.out.println(article);
        }
    }
}
