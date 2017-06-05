package app.properties.custom.imooc.com.cashexceptiondemo.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by hasee on 2017/6/5.
 */

public class GsonUtil {
    //http://www.cnblogs.com/chenlhuaf/archive/2011/05/01/gson_test.html

    /**
     * 生成Json字符串
     */
    public static <T> String Json2Obj( Class<T> t) {
        Gson gson = new Gson();
        return gson.toJson(t);
    }
    /**
     * json转成单一实体对象
     *
     * @param json
     * @param t
     * @return
     */
    public static <T> T Json2Obj(String json, Class<T> t) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * json转成对象列表或者其他结构
     *
     */
    public static <T> List<T> Json2ObjList(String json, Class<T> t) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, new TypeToken<List<T>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
