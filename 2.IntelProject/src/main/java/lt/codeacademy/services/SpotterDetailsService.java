package lt.codeacademy.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lt.codeacademy.entities.Spotter;
import lt.codeacademy.entities.SpotterDAO;

@Service
public class SpotterDetailsService implements UserDetailsService {
	 @Autowired
	    private SpotterDAO spotterDAO;
	
	 @Override
	    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
	        Spotter spotter = spotterDAO.findSpotter(name);
	        System.out.println("Spotter= " + spotter);

	        if (spotter == null) {
	            throw new UsernameNotFoundException("User " //
	                    + name + " was not found in the database");
	        }

	        // EMPLOYEE,MANAGER,..
	        String role = spotter.getUser_role();

	        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

	        // ROLE_EMPLOYEE, ROLE_MANAGER
	        GrantedAuthority authority = new SimpleGrantedAuthority(role);

	        grantList.add(authority);

	        boolean enabled = true;
	        boolean accountNonExpired = true;
	        boolean credentialsNonExpired = true;
	        boolean accountNonLocked = true;

	        UserDetails userDetails = (UserDetails) new User(spotter.getName(), //
	        		spotter.getPassword(), enabled, accountNonExpired, //
	                credentialsNonExpired, accountNonLocked, grantList);

	        return userDetails;
}
}
