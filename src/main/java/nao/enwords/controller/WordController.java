package nao.enwords.controller;

import nao.enwords.model.Word;
import nao.enwords.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class WordController {

    private WordRepository wordRepository;

    @Autowired
    public WordController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @RequestMapping(value = "/words", method = RequestMethod.GET, produces = "application/json")
    public List<Word> words(@RequestParam(name = "groupId") long groupId) {
        return wordRepository.findByGroupId(groupId);
    }

    @RequestMapping(value = "/words/{wordId}", method = RequestMethod.GET, produces = "application/json")
    public Word word(@PathVariable long wordId) {
        return wordRepository.findOne(wordId);
    }

    @RequestMapping(value = "/words/{wordId}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable long wordId) {
        wordRepository.delete(wordId);
    }

    @RequestMapping(value = "/words", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Word create(@RequestBody Word word) {
        return wordRepository.save(word);
    }

    @RequestMapping(value = "/words/{wordId}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public Word update(@PathVariable long wordId, @RequestBody Word word) {
        Word wordInfo = wordRepository.findOne(wordId);

        if (wordInfo == null) {
            throw new IllegalArgumentException("Word doesn't exist.");
        }

        return wordRepository.save(word);
    }

}
