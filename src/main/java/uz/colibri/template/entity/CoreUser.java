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
public class CoreUser extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_generator")
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    private String email;
    private String phone;
    private String password;
    private int activityStatus;
    private Date lastActivityStatus;

    public CoreUser(String email) {
        this.email = email;
    }
}
