package lt.codeacademy.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lt.codeacademy.repositories.SpotterRepository;




public class CustomSpotterDetailsService implements UserDetailsService {

	@Autowired
    private SpotterRepository spotterRepo;
     
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Spotter spotter = spotterRepo.findByName(name).orElseThrow(() -> new UsernameNotFoundException("User not find"));
        /*if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }*/
        return new CustomSpotterDetails(spotter);
    }


}
