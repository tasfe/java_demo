package gson.dto;

import com.google.gson.annotations.Expose;

import java.util.Calendar;
import java.util.List;

/**
 * Created by zhdxu on 2017/8/15.
 */
public class CategoryDTO {
    /**
     * Expose 注解配合GsonBuider使用
     * field未注解 默认 Expose true true    //序列化、反序列化排除
     * Expose 默认false false   //序列化、反序列化不排除
     */


    @Expose int id;
    @Expose String name;
    @Expose List<CategoryDTO> children;

    @Expose(deserialize = false, serialize = false)
    CategoryDTO parent;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryDTO> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryDTO> children) {
        this.children = children;
    }

    public CategoryDTO getParent() {
        return parent;
    }

    public void setParent(CategoryDTO parent) {
        this.parent = parent;
    }
}
