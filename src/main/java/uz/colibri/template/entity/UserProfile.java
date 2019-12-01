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
public class UserProfile extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq")
    private int userProfileId;
    @ManyToOne
    private CoreUsers user;
    private String fName,lName,mName,docSerial,docNumber,pnfl,sex;
    private Date birthDate;

}
