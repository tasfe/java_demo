package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import gson.dto.DataDTO;
import gson.dto.DemoDTO;

import javax.xml.crypto.Data;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Date;

/**
 * Gson的流式反序列化
 * Gson的流式序列化
 * GsonBuilder 导出null字段，格式化日期、格式化输出
 */
public class Test2 {

    public static Gson gson = new Gson();
    public static String json;
    public static DataDTO<DemoDTO> dataDTO;


    public static void init() {
        dataDTO = new DataDTO<>();
        DemoDTO demoDto = new DemoDTO();
        demoDto.setAge(24);
        demoDto.setName("zdxu");
        dataDTO.setT(demoDto);
        json = gson.toJson(dataDTO);
    }

    /**
     * 反序列化
     * @throws Exception
     */
    public static void fromJson() throws Exception {

        //json字符串 class type
        DataDTO data1 = gson.fromJson(json,DataDTO.class);
        DataDTO data2 = gson.fromJson(json, new TypeToken<DataDTO<DemoDTO>>(){}.getType());

        //jsonElement class type
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        DataDTO data3 = gson.fromJson(jsonObject,DataDTO.class);
        DataDTO data4 = gson.fromJson(jsonObject, new TypeToken<DataDTO<DemoDTO>>(){}.getType());

        //手动
        DataDTO<DemoDTO> dataDTO1 = new DataDTO<>();
        DemoDTO demoDto1 = new DemoDTO();
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.beginObject();
        while (reader.hasNext()) {
            String s = reader.nextName();
            switch (s) {
                case "t":
                    reader.beginObject();
                    while(reader.hasNext()) {
                        String type = reader.nextName();
                        switch (type) {
                            case "name":
                                demoDto1.setName(reader.nextString());
                                break;
                            case "age":
                                demoDto1.setAge(reader.nextInt());
                                break;
                        }
                    }
                    reader.endObject();
                    dataDTO1.setT(demoDto1);
                    break;
            }
        }
        reader.endObject();

        System.out.println(gson.toJson(dataDTO1));
    }

    public static void toJson() throws Exception{
        String jsonValue = gson.toJson(dataDTO);
        gson.toJson(dataDTO, System.out);


        //手动
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(System.out));
        writer.beginObject()
                .name("name").value("zdxu")
                .name("age").value(24)
                .name("email").nullValue()
                .endObject();
        writer.flush();

    }

    /**
     * 使用GsonBuilder 导出null值、格式化输出、日期时间
     */
    public static void test() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.serializeNulls().create();
        dataDTO.getT().setName(null);
        gson.toJson(dataDTO, System.out);

        dataDTO.getT().setName("zdxu");
        dataDTO.getT().setDate(new Date());
        dataDTO.getT().setHtml("<html><span color='red'>111</span></html>");

        Gson gson1 = new GsonBuilder()
                //序列化null
                .serializeNulls()
                // 设置日期时间格式，另有2个重载方法
                // 在序列化和反序化时均生效
                .setDateFormat("yyyy-MM-dd")
                // 禁此序列化内部类
                .disableInnerClassSerialization()
                //生成不可执行的Json（多了 )]}' 这4个字符）
                .generateNonExecutableJson()
                //禁止转义html标签
                .disableHtmlEscaping()
                //格式化输出
                .setPrettyPrinting()
                .create();
        gson1.toJson(dataDTO, System.out);
    }

    public static void main(String[] args) throws Exception{
        init();
        fromJson();
        toJson();
        test();
    }
}
