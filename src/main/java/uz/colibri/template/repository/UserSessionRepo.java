package uz.colibri.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.colibri.template.entity.UserSession;

public interface UserSessionRepo extends JpaRepository<UserSession,Long> {
}
