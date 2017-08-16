package gson.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhdxu on 2017/8/15.
 */
public class ResultDTO<T> {
    int code;
    @SerializedName(value = "message", alternate = {"msg"})
    String message;
    DataDTO<T> dataDTO;
//    T t;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public DataDTO<T> getDataDTO() {
        return dataDTO;
    }
    public void setDataDTO(DataDTO<T> dataDTO) {
        this.dataDTO = dataDTO;
    }

//    public T getT() {
//        return t;
//    }
//
//    public void setT(T t) {
//        this.t = t;
//    }
}
