package com.example.simplecrudapp.service.impl;

import com.example.simplecrudapp.io.entity.AdminEntity;
import com.example.simplecrudapp.io.repository.AdminRepository;
import com.example.simplecrudapp.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
        private AdminRepository adminRepository;

        public AdminServiceImpl(AdminRepository adminRepository){
            super();
            this.adminRepository = adminRepository;
        }

    @Override
    public AdminEntity createAdmin(AdminEntity admin) {
        return adminRepository.save(admin);
    }


}
