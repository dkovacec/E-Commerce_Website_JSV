package com.brigths.Final.Countdown.Project.service;

import com.brigths.Final.Countdown.Project.model.Role;

import java.util.List;

public interface RoleService {

    Role saveRole (Role role);

    List<Role> getAllRoles();

    Role getRoleById (long id);

    Role updateRoleById (long id, Role role);

    void deleteRoleById (long id);

    boolean existsRoleById(long id);

}
