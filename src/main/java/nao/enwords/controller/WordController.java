package nao.enwords.controller;

import nao.enwords.model.Word;
import nao.enwords.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
