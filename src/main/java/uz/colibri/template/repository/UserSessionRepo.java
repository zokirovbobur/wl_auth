package uz.colibri.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.colibri.template.entity.UserSession;

import java.util.Optional;

public interface UserSessionRepo extends JpaRepository<UserSession,Long> {
    boolean existsBySessionId(String sessionId);

    UserSession findUserSessionBySessionId(String sessionId);
}
