package uz.colibri.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.colibri.template.entity.UserModel;

public interface UserRepo extends JpaRepository<UserModel,Integer> {

}
