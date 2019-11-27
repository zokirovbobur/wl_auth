package uz.colibri.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import uz.colibri.template.dto.ResponseModel;
import uz.colibri.template.entity.TestModel;
import uz.colibri.template.entity.UserModel;
import uz.colibri.template.repository.TestRepo;
import uz.colibri.template.repository.UserRepo;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestRepo repo;
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public ResponseModel responseModel(){
        return new ResponseModel(0,"success",new TestModel());
    }
    @PostMapping
    public ResponseModel postNewUser(@RequestBody TestModel testModel){
        userRepo.save(new UserModel());
        return new ResponseModel(repo.save(testModel));
    }

    @GetMapping("all")
    public ResponseModel testModels(){
        return new ResponseModel(repo.findAll());
    }

    @DeleteMapping
    public ResponseModel delete(@RequestBody TestModel userModelTest2){
        repo.delete(userModelTest2);
        return new ResponseModel(0,"Delete", userModelTest2);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("test")
    public boolean test(){
        return jdbcTemplate.queryForObject("select exists(select 1 from user_session_table ust where ust.session_id = ? and ust.user_model_user_id = ?)",boolean.class,"test",1);
    }

}
