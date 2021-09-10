package io.learning.springbootmysql.service;

import io.learning.springbootmysql.domain.Word;

import java.util.List;


public interface WordService {
    Word saveWord(final Word word);
    List<Word> findWordsByType(final String type);
    List<Word> searchWords(final String english,
                           final String spanish,
                           final String swedish);
    List<Word> getAllWords();
}
