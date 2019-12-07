package uz.colibri.template.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestMail {
    private String emailAddress;
    private String title;
    private String content;
}
