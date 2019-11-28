package uz.colibri.template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MailCodesHistory {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mail_h_seq")
    private long mc_id;
    private String email,mailCode;
}
