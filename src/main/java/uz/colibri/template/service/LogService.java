package uz.colibri.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.colibri.template.entity.LogData;
import uz.colibri.template.repository.LogRepo;

@Service
public class LogService {
    @Autowired
    private LogRepo repo;

    public void addLog(int status, String message){
        repo.save(new LogData(status,message));
    }
}
