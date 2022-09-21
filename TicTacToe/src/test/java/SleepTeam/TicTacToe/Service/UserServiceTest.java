package SleepTeam.TicTacToe.Service;

import SleepTeam.TicTacToe.Model.User;
import SleepTeam.TicTacToe.Repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
    @Mock
    private UserRepo userRepo;
    @InjectMocks
    private UserService userService;
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        this.userService = new UserService(userRepo);
    }

    @Test
    public void findById_doesNotReturnNull(){
        long userId = 1;
        when(userRepo.findById(userId)).thenReturn(new User());

        assertNotNull(userService.findById(userId));
    }

    @Test
    public void findById_callsRepoByFindByIdMethod(){
        //arrange
        long userId = 1;
        userService.findById(userId);
        verify(userRepo).findById(userId);
    }

    @Test
    public void findByUsername_doesNotReturnNull(){
        when(userRepo.findByUsername("test")).thenReturn(new User());
        assertNotNull(userService.findByUsername("test"));
    }

    @Test
    public void findByUsername_callsRepoByFindUsernameMethod(){
        String userTest ="test";
        userService.findByUsername(userTest);
        verify(userRepo).findByUsername(userTest);
    }


}
