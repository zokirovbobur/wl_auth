package uz.colibri.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.colibri.template.dto.*;
import uz.colibri.template.service.AuthService;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("mailCR")
    public ResponseModel mailCR(@RequestBody MailModel mailModel){
        System.out.println(mailModel);
        return service.mailCR(mailModel);
    }

    @PostMapping("/mailCC")
    public Result confirmMail(@RequestBody RequestModel requestModel){
        return service.confirmMail(requestModel);
    }

    @PostMapping("/checkUsername")
    public Result checkUsername(@RequestBody RequestModel requestModel){
        return service.isUserNameFree(requestModel);
    }

    @PostMapping("/login")
    public ResponseModel login(@RequestBody RequestModel requestModel){
        return service.login(requestModel);
    }

    @PostMapping("/signUp")
    public ResponseModel signUp(@RequestBody RequestModel requestModel){
        return service.signUp(requestModel);
    }

}
