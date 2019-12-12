package uz.colibri.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.colibri.template.entity.MailCodes;

import javax.transaction.Transactional;

public interface MailRepo extends JpaRepository<MailCodes,Long> {
    boolean existsByEmail(String email);
    boolean existsByMailCode(int mailCode);
    MailCodes findByMailCode(int mailCode);
    @Transactional
    void deleteByMailCode(int mailCode);

}
