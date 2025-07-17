package ems.demo.springproject.service;

import ems.demo.springproject.entityvalues.Userdetail;
import ems.demo.springproject.repository.Userrepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class Customuserdetailsservice implements UserDetailsService {
    private final Userrepository userrepository;
    public Customuserdetailsservice(Userrepository userrepository){
        this.userrepository=userrepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
        Userdetail user= userrepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return  new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(()->"ROLE_"+user.getRole())
        );
    }
}
