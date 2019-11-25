package uz.colibri.template.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel {
    private int status;
    private String message;
    private Object data;

    public ResponseModel(Object data) {
        this.data = data;
        this.status = 0;
        this.message = "success";
    }
}
