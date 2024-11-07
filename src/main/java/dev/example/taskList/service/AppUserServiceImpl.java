package dev.example.taskList.service;

import dev.example.taskList.model.AppUser;
import dev.example.taskList.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class AppUserServiceImpl implements AppUserService {

        @Autowired
        private AppUserRepository userRepository;

        @Override
        public AppUser createAppUser(AppUser AppUser) {
            return userRepository.save(AppUser);
        }

        @Override
        public AppUser getAppUserById(Long id) {
            return userRepository.findById(id).orElse(null);
        }

        @Override
        public List<AppUser> getAllUsers() {
            return userRepository.findAll();
        }

        @Override
        public AppUser updateUser(Long id, AppUser user) {
            if (userRepository.existsById(id)) {
                user.setId(id);
                return userRepository.save(user);
            }
            return null;
        }

        @Override
        public boolean deleteUser(Long id) {
            userRepository.deleteById(id);
            Optional <AppUser> user = userRepository.findById(id);
            return user.isEmpty()
                ? false : true;
        }


}
