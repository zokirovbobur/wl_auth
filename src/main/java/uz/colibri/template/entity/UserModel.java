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
@Entity(name = "core_users")
public class UserModel extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_generator")
    @Column(name = "user_id")
    private int userId;
    private String userName,email,phone,password;
    private int activityStatus;
    private Date lastActivityStatus;


}
