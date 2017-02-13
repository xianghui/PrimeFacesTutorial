/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entity.User;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import session.UserSessionBeanLocal;

/**
 *
 * @author lekhsian
 */
@ManagedBean
@RequestScoped
public class UserManagedBean {
    private String name;
    private String email;
    private String password;
    private String role;
    
    @EJB
    private UserSessionBeanLocal userSessionBean;
    
    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
    }
    
    public String logout() throws Exception{
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        request.logout();
        
        return "index.xhtml?faces-redirect=true";
    }
    
    public String createNewUser(){
        User u = new User(name, email, password);
        userSessionBean.addUser(u, role);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Added user"));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        
        return "/index.xhtml?faces-redirect=true";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
    
}
