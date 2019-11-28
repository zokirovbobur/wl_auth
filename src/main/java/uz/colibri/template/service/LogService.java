package uz.colibri.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.colibri.template.repository.LogRepo;

@Service
public class LogService {
    @Autowired
    private LogRepo repo;
}
