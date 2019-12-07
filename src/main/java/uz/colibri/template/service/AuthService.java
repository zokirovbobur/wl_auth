package uz.colibri.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.colibri.template.dto.*;
import uz.colibri.template.entity.CoreUser;
import uz.colibri.template.entity.MailCodes;
import uz.colibri.template.entity.MailCodesHistory;
import uz.colibri.template.entity.UserSession;
import uz.colibri.template.repository.MailHistoryRepo;
import uz.colibri.template.repository.MailRepo;
import uz.colibri.template.repository.UserRepo;
import uz.colibri.template.repository.UserSessionRepo;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LogService logService;
    @Autowired
    private MailRepo mailRepo;
    @Autowired
    private MailHistoryRepo mailHistoryRepo;
    @Autowired
    private UserSessionRepo sessionRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseModel mailCR(MailModel mailModel){
        //TODO find and handle possible errors
        String email = mailModel.getEmail();
        if(!userRepo.existsByEmail(email)){
            CoreUser coreUser = userRepo.save(new CoreUser(email));
            String sessionId = passwordEncoder.encode(email);
            int mailCode = (int) ((1000000*Math.random())+1);
            mailRepo.save(new MailCodes(email,mailCode));
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

    public ResponseModel confirmMail(RequestModel requestModel){
        Result result = new Result();
        String sessionId = requestModel.getSessionId();
        int mailCode = requestModel.getMailCode();
        String email = mailRepo.findByMailCode(mailCode).getEmail();
        if (sessionRepo.isSessionExist(sessionId)){
            if (mailRepo.existsByMailCode(mailCode)){
                // delete mail code from mail_codes table
                mailRepo.deleteByMailCode(mailCode);
                //save current email and mail_code to mail_code_history table
                mailHistoryRepo.save(new MailCodesHistory(email,mailCode));
                // return response
                result.setSuccess(true);
                return new ResponseModel(2,"Success",result);
            }else {
                result.setSuccess(false);
                return new ResponseModel(2,"Mail code is false",result);
            }
        }else {
            result.setSuccess(false);
            return new ResponseModel(2,"Session is expired",result);
        }
    }

    public ResponseModel isUserNameFree(RequestModel requestModel){
        Result result = new Result();
        String userName = requestModel.getUserName();
        if (!userRepo.isUserNameExist(userName)){
            result.setSuccess(true);
            return new ResponseModel(result);
        }else {
            result.setSuccess(false);
            return new ResponseModel(result);
        }
    }

    public ResponseModel login(RequestModel requestModel){
        String username = requestModel.getUserName();
        String email = requestModel.getEmail();
        String phoneNumber = requestModel.getPhoneNumber();
        String password = requestModel.getPhoneNumber();
        Result result = new Result();
        SessionModel sessionModel = new SessionModel();
        if (username != null){
            if (userRepo.isUserNameExist(username)){
                sessionModel.setSessionId("session");
                sessionModel.setToken("token");
                return new ResponseModel(sessionModel);
            }else {
                result.setSuccess(false);
                return new ResponseModel("UserName not found",result);
            }
        }else if (password != null){
            if (userRepo.isPasswordExist(password)){
                sessionModel.setSessionId("session");
                sessionModel.setToken("token");
                return new ResponseModel(sessionModel);
            }else {
                result.setSuccess(false);
                return new ResponseModel("Password not found",result);
            }
        }else if (email != null){
            if (userRepo.isEmailExist(email)){
                sessionModel.setSessionId("session");
                sessionModel.setToken("token");
                return new ResponseModel(sessionModel);
            }else {
                result.setSuccess(false);
                return new ResponseModel("Email not found",result);
            }
        }
        return new ResponseModel();
    }

    public ResponseModel signUp(RequestModel requestModel){
        String username = requestModel.getUserName();
        String password = requestModel.getPassword();
        String sessionId = requestModel.getSessionId();
        int userId = sessionRepo.findUserSessionBySessionId(sessionId).getUser().getUserId();
        // update user info
        userRepo.updateUserInfo(username,password,userId);
        SessionModel sessionModel = new SessionModel(sessionId,"token");
        return new ResponseModel(sessionModel);
    }
}
