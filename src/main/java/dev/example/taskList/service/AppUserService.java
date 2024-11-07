package dev.example.taskList.service;

import dev.example.taskList.model.AppUser;

import java.util.List;

public interface AppUserService {

    AppUser createAppUser(AppUser AppUser);
    AppUser getAppUserById(Long id);
    List<AppUser> getAllUsers();
    AppUser updateUser(Long id, AppUser AppUser);
    boolean deleteUser(Long id);
}
