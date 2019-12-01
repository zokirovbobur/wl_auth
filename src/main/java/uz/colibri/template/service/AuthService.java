package uz.colibri.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.colibri.template.dto.MailModel;
import uz.colibri.template.dto.ResponseModel;
import uz.colibri.template.dto.SessionModel;
import uz.colibri.template.entity.CoreUser;
import uz.colibri.template.entity.MailCodes;
import uz.colibri.template.entity.UserSession;
import uz.colibri.template.repository.MailRepo;
import uz.colibri.template.repository.UserRepo;
import uz.colibri.template.repository.UserSessionRepo;

@Service
public class AuthService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LogService logService;
    @Autowired
    private MailRepo mailRepo;
    @Autowired
    private UserSessionRepo sessionRepo;

    public ResponseModel mailCR(MailModel mailModel){
        //TODO check mail not exists // done
        //TODO insert mail code with this email // done
        //TODO insert session with this user id
        //TODO create user account with this email
        //TODO return session id from all valid actions
        String email = mailModel.getEmail();
        if(!userRepo.existsByEmail(email)){
            String sessionId = SessionModel.fromString(email);
            mailRepo.save(new MailCodes(email,sessionId));
            int userId = userRepo.save(new CoreUser(email)).getUserId();
            sessionRepo.save(new UserSession());

        }else {
            return new ResponseModel(1,"mail address is already registered",null);
        }
        return new ResponseModel();
    }
}
