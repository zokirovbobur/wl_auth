package uz.colibri.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.colibri.template.entity.TestModel;

public interface TestRepo extends JpaRepository<TestModel,Integer> {

}
