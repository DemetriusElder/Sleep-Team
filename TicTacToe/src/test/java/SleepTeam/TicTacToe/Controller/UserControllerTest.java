package SleepTeam.TicTacToe.Controller;

import SleepTeam.TicTacToe.Model.User;
import SleepTeam.TicTacToe.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTest {

    @Mock
    private UserService userService;
    private UserController userController;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        this.userController = new UserController(userService);
    }

    @Test
    public void findById_doesNotReturnNull() {
        //arrange
        when(userService.findById(1L)).thenReturn(new User());

        //act/assert
        assertNotNull(userController.findById(1L));
    }

    @Test
    public void findById_callsServiceFindByIdMethod(){
        //arrange
        Long userId = 1L;
        //act
        userController.findById(userId);
        //assert
        verify(userService).findById(userId);
    }

    @Test
    public void findById_returnsUserFromUserService(){
        //arrange
        Long userId = 1L;
        User user = new User("test","test",0,0);
        when(userService.findById(userId)).thenReturn(user);

        //act
        User result = userController.findById(userId);

        //assert
        assertEquals(user, result);
    }

    @Test
    public void findByUsername_notNull(){
        when(userService.findByUsername("test")).thenReturn(new User());
        assertNotNull(userController.findByUsername("test"));
    }

    @Test
    public void findByUsername_callsServiceByMethod(){
        String testUser = "test";
        userController.findByUsername(testUser);
        verify(userService).findByUsername(testUser);
    }

    @Test
    public void findByUsername_returnsUserFromUserService(){
        String testUser = "test";
        User expectedUser = new User("test", "test", 0, 0);
        when(userService.findByUsername(testUser)).thenReturn(expectedUser);

        User result = userController.findByUsername(testUser);

        assertEquals(expectedUser,result);
    }
}
