/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.User;
import javax.ejb.Local;

/**
 *
 * @author lekhsian
 */
@Local
public interface UserSessionBeanLocal {
    public void addUser(User u, String role);
}
