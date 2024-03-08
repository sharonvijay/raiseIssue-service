package org.reg.raiseIssueservice.repository;

import org.reg.raiseIssueservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
