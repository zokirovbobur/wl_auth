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
public class UserSession extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usser_session_seq")
    private long us_id;
    @ManyToOne
    private CoreUser user;
    private String sessionId;
    private Date timeOut;
}
