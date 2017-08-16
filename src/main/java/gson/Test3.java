package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import gson.dto.CategoryDTO;
import gson.dto.ModifierSample;
import gson.dto.SinceUntilSample;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * Created by zhdxu on 2017/8/15.
 */
public class Test3 {

    static CategoryDTO category = new CategoryDTO();
    static String json;
    static SinceUntilSample sinceUntilSample = new SinceUntilSample();
    static ModifierSample modifierSample = new ModifierSample();

    static void init() {
        category.setId(11);
        category.setName("zdxu");

        List<CategoryDTO> children = new ArrayList<>();
        CategoryDTO child1 = new CategoryDTO();
        child1.setId(1101);
        child1.setName("1101");
        CategoryDTO child2 = new CategoryDTO();
        child2.setId(1102);
        child2.setName("1102");
        children.add(child1);
        children.add(child2);

        CategoryDTO parent = new CategoryDTO();
        parent.setId(1);
        parent.setName("1");

        category.setChildren(children);
        category.setParent(parent);

        json = new Gson().toJson(category);


        sinceUntilSample.setSince("since");
        sinceUntilSample.setUntil("until");

        modifierSample.setDefaultField("default");
        modifierSample.setPrivateField("private");
        modifierSample.setProtectedField("protected");
        modifierSample.setPublicField("public");
    }

    /**
     * 字段过滤
     *    1、基于@Expose注解
     *
     */
    public static void fieldFilter() {
        new Gson().toJson(category, System.out);
        CategoryDTO categoryDTO = new Gson().fromJson(json, CategoryDTO.class);

        System.out.println();
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        gson.toJson(category, System.out);
        CategoryDTO categoryDTO1 = gson.fromJson(json, CategoryDTO.class);

        System.out.println();
    }

    public static void filterByVersion() {
        Gson gson = new GsonBuilder()
                .setVersion(3)
                .create();
        String json = gson.toJson(sinceUntilSample);
        System.out.println(json);
        SinceUntilSample sinceUntilSample = gson.fromJson(json, SinceUntilSample.class);
        System.out.println();
    }

    public static void filterByModifier() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers( Modifier.PRIVATE)
                .create();

        String json = gson.toJson(modifierSample);
        System.out.println(json);
        json = json.replace("final", "finalTest");

        new Gson().toJson(modifierSample, System.out);
        System.out.println();
        ModifierSample m = new Gson().fromJson(new Gson().toJson(modifierSample), ModifierSample.class);

        ModifierSample modifierSample = gson.fromJson(json, ModifierSample.class);
        System.out.println(modifierSample);
    }

    public static void main(String[] arg) {
        init();
        filterByModifier();
    }
}
