package com.brigths.Final.Countdown.Project.service;

import com.brigths.Final.Countdown.Project.model.Role;
import com.brigths.Final.Countdown.Project.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl (RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role saveRole(Role role) {
        Role newRole = roleRepository.save(role);
        return newRole;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(long id) {
        Optional<Role> roleData = roleRepository.findById(id);

        if(roleData.isPresent()) {
            return roleData.get();
        } else {
            return null;
        }
    }

    @Override
    public Role updateRoleById(long id, Role role) {
        Role roleData  = getRoleById(id);
        if(roleData != null) {
            roleData.setName((role.getName()));
            return roleData;
        }

        return null;
    }

    @Override
    public void deleteRoleById(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public boolean existsRoleById(long id) {
        return existsRoleById(id);
    }
}
