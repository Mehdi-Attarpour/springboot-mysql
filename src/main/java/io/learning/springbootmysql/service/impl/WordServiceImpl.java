package io.learning.springbootmysql.service.impl;

import io.learning.springbootmysql.domain.Word;
import io.learning.springbootmysql.repository.WordRepository;
import io.learning.springbootmysql.service.WordService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WordServiceImpl implements WordService {

    private final WordRepository repository;

    public WordServiceImpl(final WordRepository repository) {
        this.repository = repository;
    }

    @Override
    public Word saveWord(final Word word) {
        return repository.save(word);
    }

    @Override
    public List<Word> findWordsByType(final String type) {
        return repository.findWordsByType(type);
    }

    @Override
    public List<Word> searchWords(final String english, final String spanish, final String swedish) {
        return repository.findWords(english, spanish, swedish);
    }

    @Override
    public List<Word> getAllWords() {
        return repository.findAll();
    }
}
