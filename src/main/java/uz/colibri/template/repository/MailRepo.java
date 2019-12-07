package uz.colibri.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.colibri.template.entity.MailCodes;

import java.util.Optional;

public interface MailRepo extends JpaRepository<MailCodes,Long> {
    boolean existsByEmail(String email);
    boolean existsByMailCode(int mailCode);
    void deleteByMailCode(int mailCode);
    MailCodes findByMailCode(int mailCode);
}
