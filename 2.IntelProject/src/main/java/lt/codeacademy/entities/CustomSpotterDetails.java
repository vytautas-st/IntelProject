package lt.codeacademy.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class CustomSpotterDetails implements UserDetails {
	 private Spotter spotter;
     
	    public CustomSpotterDetails(Spotter spotter) {
	        this.spotter = spotter;
	    }
	 
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return null;
	    }
	 
	    @Override
	    public String getPassword() {
	        return spotter.getPassword();
	    }
	 
	    @Override
	    public String getUsername() {
	        return spotter.getName();
	    }
	 
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	 
	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

}
