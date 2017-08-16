package gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import gson.dto.DataDTO;
import gson.dto.DemoDTO;
import gson.dto.ResultDTO;

import java.util.*;

/**
 * gson 的基本用法
 * 属性重命名@SerializedName 注解的使用
 * gson中使用泛型
 */
public class Test1 {


    public static void main(String[] args) {
        ResultDTO<List<DemoDTO>> resultDTO = new ResultDTO();
        DataDTO<List<DemoDTO>> dataDTO = new DataDTO();
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setName("zdxu");
        demoDTO.setAge(24);
        List<DemoDTO> list = new ArrayList();
        list.add(demoDTO);
        dataDTO.setT(list);
        resultDTO.setCode(1001);
        resultDTO.setMessage("success");
        resultDTO.setDataDTO(dataDTO);

        String json = new Gson().toJson(resultDTO);
        json = json.replace("message", "msg");

        ResultDTO resultDTO1 = new Gson().fromJson(json, new TypeToken<ResultDTO<List<DemoDTO>>>(){}.getType());

        System.out.print("..end");
    }
}
