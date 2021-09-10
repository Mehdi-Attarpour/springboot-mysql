package io.learning.springbootmysql.controller;

import io.learning.springbootmysql.domain.Word;
import io.learning.springbootmysql.service.WordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/word")
public class WordController {

    private final WordService wordService;

    public WordController(final WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping()
    public ResponseEntity<List<Word>> getAllWords(){
        return new ResponseEntity<>(
                wordService.getAllWords(),
                HttpStatus.OK
        );
    }

    @PostMapping()
    public ResponseEntity<Word> saveWord(@RequestBody final Word word){
        return new ResponseEntity<>(
                wordService.saveWord(word),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{type}")
    public ResponseEntity<List<Word>> getWordByType(@PathVariable final String type){
        return new ResponseEntity<>(
                wordService.findWordsByType(type),
                HttpStatus.OK
        );
    }
    @GetMapping(path = "/search")
    public ResponseEntity<List<Word>> searchWords(@RequestParam(value = "english", required = false) final String english,
                                                  @RequestParam(value = "spanish", required = false) final String spanish,
                                                  @RequestParam(value = "swedish", required = false) final String swedish){
        return new ResponseEntity<>(
                wordService.searchWords(english, spanish, swedish),
                HttpStatus.OK
        );
    }
}
