package nao.enwords.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "trainings")
public class Training implements Serializable {
    private static final long serialVersionUID = 6793979731528689130L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "training_id")
    private Long trainingId;

    @Column(name = "group_id")
    private Long groupId;

    private Double result;

    @Column(name = "training_date")
    private LocalDateTime trainingDate;

    protected  Training() {}

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getTrainingDate() {
        return trainingDate.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public void setTrainingDate(LocalDateTime trainingDate) {
        this.trainingDate = trainingDate;
    }
}
