package nao.enwords.controller;

import nao.enwords.model.Word;
import nao.enwords.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WordController {

    private WordRepository wordRepository;

    @Autowired
    public WordController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @RequestMapping(value = "/words/{groupId}", method = RequestMethod.GET, produces = "application/json")
    public List<Word> words(@PathVariable long groupId) {
        return wordRepository.findByGroupId(groupId);
    }


    @RequestMapping(value = "/words/info/{wordId}", method = RequestMethod.GET, produces = "application/json")
    public Word word(@PathVariable long wordId) {
        return wordRepository.findOne(wordId);
    }

    @RequestMapping(value = "/words/info/{wordId}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable long wordId) {
        wordRepository.delete(wordId);
    }

    @RequestMapping(value = "/words/info", method = RequestMethod.POST,
            produces = "application/json", consumes = "application/json")
    public Word save(@RequestBody Word word) {
        return wordRepository.save(word);
    }

}
