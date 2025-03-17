package dev.jhonatta.people_management_system.repository;

import dev.jhonatta.people_management_system.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
