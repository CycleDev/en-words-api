package nao.enwords.model;

import javax.persistence.*;

@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name = "word_id")
    private long id;
    private String word;
    private String translation;
    private String comments;

    @Column(name = "group_id")
    private long groupId;

    protected Word() {}

    public Word(String word, String translation, String comments, long groupId) {
        this.word = word;
        this.translation = translation;
        this.comments = comments;
        this.groupId = groupId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
}
