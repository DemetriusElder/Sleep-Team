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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

//    @Test
//    public void updateWinPlusOne_doesNotReturnNull(){
//        String userTest = "test";
//        when(userRepo.findByUsername(userTest)).thenReturn(1));
//        assertNotNull(userService.updateWinPlusOne("test"));
//    }
//
//    @Test
//    public void updateWinPlusOne_returnUser(){
//        String userTest = "test";
//        when(userRepo.findByUsername(userTest)).thenReturn(new User());
//        User result = userService.updateWinPlusOne("test");
//        assertThat(result, isA(User.class));
//    }
//    @Test
//    public void updateWinPlusOne_returnUserPlusOne(){
//        String userTest = "test";
//        User expectedUser = new User("test","test",0,0);
//        expectedUser.setWins(1);
//        when(userRepo.findByUsername(userTest)).thenReturn(expectedUser);
//        User result = userService.updateWinPlusOne(userTest);
//        assertThat(result, isA(User.class));
//        assertEquals(result, expectedUser);
//    }
//
//    @Test
//    public void updateWinPlusOne_callsRepoByUpDatePlusOne(){
//        String userTest = "test";
//        userService.updateWinPlusOne(userTest);
//        verify(userRepo).updateWinPlusOne(userTest);
//    }
//
//    @Test
//    public void updateWinPlusOne_callsRepoFindByUserName(){
//        String userTest = "test";
//        userService.updateWinPlusOne(userTest);
//        verify(userRepo).findByUsername(userTest);
//    }
//
//    @Test
//    public void updateLossPlusOne_ReturnNotNull(){
//        User testUser = new User();
//        when(userRepo.findByUsername("test")).thenReturn(testUser);
//        assertNotNull(userService.updateLossPlusOne("test"));
//    }
//
//    @Test
//    public void updateLossPlusOne_returnUser(){
//        User testUser = new User();
//        when(userRepo.findByUsername("test")).thenReturn(testUser);
//        User result = userService.updateLossPlusOne("test");
//        assertThat(result, isA(User.class));
//    }
//
//    @Test
//    public void updateLossPlussOne_callsRepoFindByUserName(){
//        String userTest= "test";
//        userService.updateLossPlusOne(userTest);
//        verify(userRepo).findByUsername(userTest);
//    }
//
//    @Test
//    public void updateLossPlusOne_callsRepoUpdateLossPlusOne(){
//        String userTest = "test";
//        userService.updateLossPlusOne(userTest);
//        verify(userRepo).updateLossPlusOne(userTest);
//    }
//
//    @Test
//    public void updateLossPlusOne_returnUserPlusOne(){
//        String userTest = "test";
//        User expectedUser = new User("test","test",0,0);
//        expectedUser.setLosses(1);
//        when(userRepo.findByUsername(userTest)).thenReturn(expectedUser);
//        User result = userService.updateWinPlusOne(userTest);
//        assertThat(result, isA(User.class));
//        assertEquals(result, expectedUser);
//    }
}
