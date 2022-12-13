package com.brigths.Final.Countdown.Project.controller;

import com.brigths.Final.Countdown.Project.model.Role;
import com.brigths.Final.Countdown.Project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/api")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;

    }

    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@RequestBody Role role){

        try{
            Role newRole = roleService.saveRole(new Role( role.getName() ));
            return new ResponseEntity<>(newRole, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles(@RequestParam(required = false) String name){

        try {
            List<Role> Roles = new ArrayList<>();

            if(name == null) {
                Roles = roleService.getAllRoles();
            }

            if(Roles.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(Roles,HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("roles/{RoleId}")
    public ResponseEntity<Role> getRoleById(@PathVariable("RoleId") long RoleId){
        Role Role = roleService.getRoleById(RoleId);

        if(Role != null){
            return new ResponseEntity<>(Role,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping ("roles/{roleId}")
    public ResponseEntity<Role> updateRoleById (@PathVariable("roleId") long roleId, @RequestBody Role role){

        Role updateRole = roleService.updateRoleById(roleId, role);

        if(updateRole != null){
            return new ResponseEntity<>(roleService.saveRole(updateRole),HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("roles/{roleId}")
    public ResponseEntity<Role> deleteRoleById (@PathVariable ("roleId") long roleId){
        try {
            roleService.deleteRoleById(roleId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

