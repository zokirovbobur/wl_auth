package uz.colibri.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.colibri.template.entity.CoreUser;

public interface UserRepo extends JpaRepository<CoreUser,Integer> {
    boolean existsByEmail(String email);
}
