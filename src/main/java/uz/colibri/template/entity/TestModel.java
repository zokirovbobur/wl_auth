package uz.colibri.template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TestModel {
    @Id @GeneratedValue
    private int testID;
    private String testname;
    private Boolean status;

}
