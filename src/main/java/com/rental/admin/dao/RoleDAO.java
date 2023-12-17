package com.rental.admin.dao;

/**
 * @author Wutt Yee Tun
 */

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.Role;

public interface RoleDAO extends CrudRepository<Role, Integer>{

}
