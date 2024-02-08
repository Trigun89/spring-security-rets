package com.example.simplecrudapp.io.repository;

import com.example.simplecrudapp.io.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
}
