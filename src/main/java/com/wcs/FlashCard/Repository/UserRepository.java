package com.wcs.FlashCard.Repository;

import com.wcs.FlashCard.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByMail(String text);
}
