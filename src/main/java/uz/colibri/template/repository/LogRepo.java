package uz.colibri.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.colibri.template.entity.LogData;

public interface LogRepo extends JpaRepository<LogData,Long> {

}
