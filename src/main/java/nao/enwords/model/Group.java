package nao.enwords.model;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue
    private Long id;
    private String group;

    public Group() {
    }

    public Group(long id, String group) {
        this.id = id;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
