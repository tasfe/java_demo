package gson.dto;


import java.util.Date;

/**
 * Created by zhdxu on 2017/8/15.
 */
public class DemoDTO {
    String name;
    int age;
    Date date;
    String html;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
