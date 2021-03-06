package pl.mysior.welshblackrestapi.security.user;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.mysior.welshblackrestapi.repository.ApplicationUserRepository;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserDetailsService {

    private ApplicationUserRepository applicationUserRepository;

    public UserServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
        if(applicationUser == null){
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(),applicationUser.getPassword(),Collections.emptyList());
    }

}
