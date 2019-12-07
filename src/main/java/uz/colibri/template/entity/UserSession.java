package uz.colibri.template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserSession extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_session_seq")
    private long us_id;

    @ManyToOne
    private CoreUser user;

    private String sessionId;
    private Date timeOut;

    public UserSession(CoreUser coreUser, String sessionId) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR,1);
        this.us_id = coreUser.getUserId();
        this.user = coreUser;
        this.sessionId = sessionId;
        this.timeOut = calendar.getTime();
    }
}
