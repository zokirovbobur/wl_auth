package uz.colibri.template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TestModel extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "test_generator")
    private int testID;
    private String testname;
    private Boolean status;

}
