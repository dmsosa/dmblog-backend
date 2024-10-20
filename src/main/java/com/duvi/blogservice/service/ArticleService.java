package com.duvi.blogservice.service;

import com.duvi.blogservice.model.Article;
import com.duvi.blogservice.model.Tag;
import com.duvi.blogservice.model.dto.ArticleResponseDTO;
import com.duvi.blogservice.model.dto.SetArticleDTO;
import com.duvi.blogservice.model.dto.UserResponseDTO;
import com.duvi.blogservice.model.exceptions.EntityAlreadyExistsException;
import com.duvi.blogservice.model.exceptions.EntityDoesNotExistsException;
import com.duvi.blogservice.model.exceptions.TagNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface ArticleService {

    //createDTO
    ArticleResponseDTO createDTO(Article article);

    //checkFav

    Boolean checkFav(Long articleId, String loggedUsername);

    //Basic CRUD Operations
    List<ArticleResponseDTO> getArticlesSorted();
    List<ArticleResponseDTO> getArticlesBySearch(String searchString);
    boolean matchSearch(Article article, String searchString);
    List<ArticleResponseDTO> getArticles() ;

    ArticleResponseDTO createArticle(SetArticleDTO articleDTO) throws EntityAlreadyExistsException, EntityDoesNotExistsException;
    ArticleResponseDTO getArticleBySlug(String slug) throws EntityDoesNotExistsException;
    ArticleResponseDTO getArticleById(Long id) throws EntityDoesNotExistsException;
    ArticleResponseDTO getArticleByTitle(String title) throws EntityDoesNotExistsException;
    ArticleResponseDTO updateArticle(String slug, SetArticleDTO newArticleDTO) throws EntityDoesNotExistsException;
    void deleteArticle(Long id) throws EntityDoesNotExistsException;
    void deleteArticleBySlug(String articleSlug) throws EntityDoesNotExistsException;

    //Operations related with Author
    List<ArticleResponseDTO> getByAuthor(String username) throws EntityDoesNotExistsException;

    //Operations related with User
        //Get all the users that marked a given article as favorite
    List<UserResponseDTO> getFavUsers(String slug) throws EntityDoesNotExistsException;
        //Set a new favorite article for a user
    ArticleResponseDTO setFavorite(String slug, String username) throws EntityDoesNotExistsException, EntityDoesNotExistsException;
        //Remove favorite article for a user
    ArticleResponseDTO removeFavorite(String slug, String username) throws EntityDoesNotExistsException, EntityDoesNotExistsException;

    boolean isFavorite(String slug, String username) throws EntityDoesNotExistsException;

        //Get all favorite articles of a given user
    List<ArticleResponseDTO> getFavArticles(String username) throws EntityDoesNotExistsException;

    //Operations related with Tags
    List<ArticleResponseDTO> getArticlesByTag(String tagName) throws TagNotFoundException;
    ArticleResponseDTO setTag(String slug, String tagName) throws EntityDoesNotExistsException;
    ArticleResponseDTO removeTag(String slug, String tagName) throws EntityDoesNotExistsException;
    public ArticleResponseDTO setFontColor(String slug, String backgroundColor) throws EntityDoesNotExistsException;

    public ArticleResponseDTO setBackgroundColor(String slug, String backgroundColor) throws EntityDoesNotExistsException;
    public ArticleResponseDTO setEmoji(String slug, String emoji) throws EntityDoesNotExistsException;


}
