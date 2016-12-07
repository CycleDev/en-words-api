package nao.enwords.repository;

import nao.enwords.model.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {
    List<Word> findByGroupId(long groupId);

}

