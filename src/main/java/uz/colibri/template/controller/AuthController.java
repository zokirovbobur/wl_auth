package uz.colibri.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.colibri.template.dto.MailModel;
import uz.colibri.template.dto.ResponseModel;
import uz.colibri.template.dto.SessionModel;
import uz.colibri.template.service.AuthService;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping("mailCR")
    public ResponseModel mailCR(@RequestBody MailModel mailModel){
        return service.mailCR(mailModel);
    }

}
