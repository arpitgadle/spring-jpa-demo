package in.arpitgadle.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    private Long studentId;

    @Column
    private String studentName;

    @Column
    private Integer studentTestScore;
}
