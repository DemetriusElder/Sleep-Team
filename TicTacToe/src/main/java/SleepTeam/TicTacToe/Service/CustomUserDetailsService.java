package SleepTeam.TicTacToe.Service;

import SleepTeam.TicTacToe.Model.CustomUserDetails;
import SleepTeam.TicTacToe.Model.User;
import SleepTeam.TicTacToe.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepo userRepo;
    @Autowired
    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user==null){
            throw new RuntimeException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
