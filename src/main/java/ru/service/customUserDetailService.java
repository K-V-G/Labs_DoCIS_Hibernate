/*
package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.models.UserInfo;
import ru.models.UserProfile;

import java.util.ArrayList;
import java.util.List;

@Service
public class customUserDetailService implements UserDetailServiceInt {
    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userService.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                true, true, true, true,
                getGrantedAuthority(user));
    }

    private List<GrantedAuthority> getGrantedAuthority(UserInfo userInfo) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        UserProfile userProfile = userInfo.getUserProfiles();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        return authorities;
    }
}
*/
