package uz.colibri.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.colibri.template.entity.CoreUser;

public interface UserRepo extends JpaRepository<CoreUser,Integer> {
    boolean existsByEmail(String email);

    boolean existsByUserName(String userName);
    boolean existsByPassword(String password);

//    @Modifying
//    @Query("update core_users cu set cu.user_name = ?1,cu.password = ?2 where cu.user_id = ?3")
//    void updateUserInfo(String userName,String password,int user_id);

}
