package uz.colibri.template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserModel {
    @Id
    @GeneratedValue
    private int userId;
    private String userName;
    //TODO fill with fields and methods using compatible data with diagram data

}
