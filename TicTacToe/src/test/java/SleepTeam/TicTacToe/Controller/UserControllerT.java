package SleepTeam.TicTacToe.Controller;

import SleepTeam.TicTacToe.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//integration testing
@WebMvcTest(UserController.class)
@ExtendWith(SpringExtension.class)
public class UserControllerT {
    private MockMvc mockMvc;

    @SpyBean //class testing
    private UserController userController;

    @MockBean //inject bean
    private UserService userService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build(); //isolates the controller
    }

    @Test
    public void findById_returns200Status() throws Exception{
        //act  /assert
        mockMvc.perform(get("/users/id/1")).andExpect(status().isOk());
    }

    @Test
    public void findById_callsUserServiceWithPathVariable() throws Exception{
        //arrange
        long userId = 3;
        //act
        mockMvc.perform(get("/users/id/" + userId)).andExpect(status().isOk());
        //assert -verify that the mock is called
        verify(userService).findById(userId);
        verify(userService, times(1)).findById(userId);
    }
    @Test
    public void findByUsername_returns200Status() throws Exception{
        mockMvc.perform(get("/users/username/test")).andExpect(status().isOk());

    }

    @Test
    public void findByUsername_callsUserServiceWithPathVariable() throws Exception{
        String userName = "test";
        mockMvc.perform(get("/users/username/" + userName)).andExpect(status().isOk());
        verify(userService).findByUsername(userName);
    }

    @Test
    public void updateWinPlusOne_returns200Status() throws Exception{
        mockMvc.perform(get("/users/updateWinPlusOne/test")).andExpect(status().isOk());
    }

    @Test
    public void updateWinPlusOne_callsUserServiceWithPathVariable() throws Exception{
        String testUser = "test";
        mockMvc.perform(get("/users/updateWinPlusOne/"+testUser)).andExpect(status().isOk());
        verify(userService).updateWinPlusOne(testUser);
    }

    @Test
    public void updateLossPlusOne_return200Status() throws Exception{
        mockMvc.perform(get("/users/updateLossPlusOne/test")).andExpect(status().isOk());
    }

    @Test
    public void updateLossPlusOne_callsServiceWithPathVariable() throws Exception{
        String testUser = "test";
        mockMvc.perform(get("/users/updateLossPlusOne/"+testUser)).andExpect(status().isOk());
        verify(userService).updateLossPlusOne(testUser);
    }
}


//this test is uncessary .
//    @Test
//    public void findById_throwsNotFound_invalidId() throws Exception{
//        Long userId = 5L;
//        ResponseStatusException rse = new ResponseStatusException(HttpStatus.NOT_FOUND);
//        when(userService.findById(userId)).thenThrow(rse);
//
//        //act
//        mockMvc.perform(get("/user/5")).andExpect(status().isNotFound());
//    }