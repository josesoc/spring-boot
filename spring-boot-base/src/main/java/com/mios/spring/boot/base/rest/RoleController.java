package com.mios.spring.boot.base.rest;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mios.spring.boot.base.domain.Role;
import com.mios.spring.boot.base.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
    private RoleService roleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Role> createRole(@RequestBody @Valid final Role role) {
        Role role2=roleService.addRole(role);
        
        return new ResponseEntity<Role>(role2, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/add2", method = RequestMethod.POST)
    public Role createRole2(@RequestBody @Valid final Role role) {
        return roleService.addRole(role);
    }
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Role> getAllRoles() { 
        return roleService.getRoles();
    }
}