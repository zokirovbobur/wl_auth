package uz.colibri.template.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionModel {
    private String sessionId;
    private String token;

    public SessionModel(String sessionId){
        this.sessionId = sessionId;
        this.token = null;
    }
    public String generateSessionId(){
        this.sessionId = UUID.randomUUID().toString();
        return this.sessionId;
    }
    public String generateFromString(String string){
        this.sessionId = UUID.fromString(string).toString();
        return this.sessionId;//test
    }

    public static String generate(){
        return UUID.randomUUID().toString();
    }

    public static String fromString(String string){
        return UUID.fromString(string).toString();
    }
}
