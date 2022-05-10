package com.shuz.shuzProject.domain.user;

import com.shuz.shuzProject.domain.shuz.Shuz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(String id);

}
