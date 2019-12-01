package uz.colibri.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.colibri.template.entity.CoreUsers;

public interface UserRepo extends JpaRepository<CoreUsers,Integer> {

}
