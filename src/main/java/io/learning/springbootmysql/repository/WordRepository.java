package io.learning.springbootmysql.repository;

import io.learning.springbootmysql.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {

    String QUERY = "SELECT * FROM words WHERE words.english=?1 OR words.spanish=?2 OR words.swedish=?4";

    List<Word> findWordsByType(final String type);

    @Query(value = QUERY, nativeQuery = true)
    List<Word> findWords(final String english,
                         final String spanish,
                         final String swedish);
}
