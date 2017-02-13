/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Role;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lekhsian
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User u, String role) {
        Role role1 = this.findRole(role);
        
        List<Role> roles = new ArrayList<Role>();
        roles.add(role1);
        
        u.setRoles(roles);
        
        role1.getUsers().add(u);
        em.persist(u);
        em.flush();
    }
    
    private Role findRole(String role){
        return em.find(Role.class, role);
    }
}
