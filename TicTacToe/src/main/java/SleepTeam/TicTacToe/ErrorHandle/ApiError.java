package SleepTeam.TicTacToe.ErrorHandle;


import com.fasterxml.jackson.annotation.JsonFormat;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;

import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.net.HttpURLConnection.HTTP_BAD_GATEWAY;

public class ApiError {
    private HttpStatus status; //property holds teh operation call status.
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message; //user friendly message about the error
    private String debugMessage; //property holds a system message describing the error in detail
    private List<ApiSubError> subErrors; //holds array of sub errors that happened, used to represent multiple errors in single call.
    private ApiError(){
        timestamp = LocalDateTime.now();
    }

    ApiError(HttpStatus status){
        this();
        this.status = status;
    }

    ApiError(HttpStatus status, Throwable ex){
        this();
        this.status = status;
        this.message = "Unexpected Error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    ApiError(HttpStatus status, String message, Throwable ex){
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
    public HttpStatus getStatus(){
        return status;
    }
    public void setStatus(HttpStatus status){
        this.status = status;
    }
    public void setLocalDateTime(LocalDateTime timestamp){
        this.timestamp = timestamp;
    }
    public LocalDateTime getLocalDataTime(){
        return timestamp;
    }
    public void setSubErrors(List<ApiSubError> subErrors){
        this.subErrors = subErrors;
    }
    public List<ApiSubError> getSubErrors(){
        return subErrors;
    }





}

