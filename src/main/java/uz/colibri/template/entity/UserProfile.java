package uz.colibri.template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserProfile extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq")
    private int userProfileId;
    @ManyToOne
    private CoreUser user;
    private String fName;
    private String lName;
    private String mName;
    private String docSerial;
    private String docNumber;
    private String pnfl;
    private String sex;
    private Date birthDate;

}
