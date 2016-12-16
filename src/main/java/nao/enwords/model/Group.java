package nao.enwords.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "groups")
public class Group implements Serializable {
    private static final long serialVersionUID = 1235258929580933520L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_name")
    private String group;

    protected  Group() {}

    public Group(String group) {
        this.group = group;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
