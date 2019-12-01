package uz.colibri.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.colibri.template.entity.MailCodes;

public interface MailRepo extends JpaRepository<MailCodes,Long> {
    boolean existsByEmail(String email);
}
