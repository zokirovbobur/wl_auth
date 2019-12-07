package uz.colibri.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.colibri.template.entity.MailCodesHistory;

@Repository
public interface MailHistoryRepo extends JpaRepository<MailCodesHistory,Long> {

}
