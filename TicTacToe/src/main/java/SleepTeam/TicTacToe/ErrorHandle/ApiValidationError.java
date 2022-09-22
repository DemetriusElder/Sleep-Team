package SleepTeam.TicTacToe.ErrorHandle;

/*Expresses validation problems encountered during REST call*/

public class ApiValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ApiValidationError(String object, String message){
        this.object = object;
        this.message =message;
    }
    ApiValidationError(){
    }

    public ApiValidationError(String object, String field, Object rejectedValue, String message) {
        this.object = object;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.message =message;
    }


    public void setObject(String object){
        this.object =object;
    }
    public String getObject(){
        return object;
    }

    public void setField(String field){
        this.field = field;
    }
    public String field(){
        return field;
    }
    public void setRejectedValue(Object rejectedValue){
        this.rejectedValue = rejectedValue;
    }

    public Object getRejectedValue(){
        return rejectedValue;
    }

    public void setMessage(String message){
        this.message =message;
    }
    public String getMessage(){
        return message;
    }



}
