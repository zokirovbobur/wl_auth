package uz.colibri.template.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestModel {
    private String sessionId;
    private int mailCode;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
}
