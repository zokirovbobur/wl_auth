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
        //TODO find and handle possible errors
        String email = mailModel.getEmail();
        if(!userRepo.existsByEmail(email)){
            String sessionId = SessionModel.fromString(email);
            mailRepo.save(new MailCodes(email,sessionId));
            CoreUser coreUser = userRepo.save(new CoreUser(email));
            UserSession userSession = sessionRepo.save(new UserSession(coreUser,sessionId));
            SessionModel sessionModel = new SessionModel(sessionId);
            ResponseModel responseModel;
            if (userSession.getUs_id() != 0){
                responseModel = new ResponseModel(0,"success",sessionModel);
            }else {
                responseModel = new ResponseModel(2,"unknown error",null);
            }
            return responseModel;
        }else {
            return new ResponseModel(1,"mail address is already registered",null);
        }
    }
}
