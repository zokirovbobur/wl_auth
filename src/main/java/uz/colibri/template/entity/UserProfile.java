package uz.colibri.template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserProfile {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_generator")
    private int userProfileId;
    @ManyToOne
    private UserModel user;
    private String fName,lName,mName,docSerial,docNumber,pnfl,sex;
    private Date birthDate;

}
