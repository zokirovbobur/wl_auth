package uz.colibri.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.colibri.template.dto.ResponseModel;
import uz.colibri.template.entity.TestModel;
import uz.colibri.template.repository.TestRepo;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestRepo repo;

    @GetMapping
    public ResponseModel responseModel(){
        return new ResponseModel(0,"success",new TestModel());
    }
    @PostMapping
    public ResponseModel postNewUser(@RequestBody TestModel testModel){
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

}
