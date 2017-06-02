package app.properties.custom.imooc.com.cashexceptiondemo.AsyncHttpClientDemo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.apache.http.Header;
/**
 * Created by hasee on 2017/5/25.
 */

public class AsyncHttpClientUtil {
    private Context context;
    public AsyncHttpClientUtil(Context context) {
        this.context = context;
    }

    /**
     * 通过AsyncHttpClient发送GET请求
     */
    public void loginByAsyncHttpGet() {
        String path = "http://yszjservice.shanku.info/ProudctCategroyWebService.asmx/GetProudctCategroyList";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(path, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, org.apache.http.Header[] headers, byte[] bytes) {
                Log.i("loginByAsyncHttpGet", "请求成功：" + new String(bytes));
                Toast.makeText(context,"请求成功：loginByAsyncHttpGet" ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, org.apache.http.Header[] headers, byte[] bytes, Throwable throwable) {
                 Log.i("loginByAsyncHttpGet", "请求失败： "+ new String(bytes));
                Toast.makeText(context,"请求失败：loginByAsyncHttpGet" + new String(bytes),Toast.LENGTH_SHORT).show();

            }
        });
    }




    /**
     * 通过AsyncHttpClient发送POST请求
     */
    public void loginByAsyncHttpPost() {
        String path = "http://yszjservice.shanku.info/ProudctCategroyWebService.asmx/GetProudctCategroyList";

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
      //  params.put("username", "zhangsan");
      //  params.put("password", "123");
        client.post(path, params, new AsyncHttpResponseHandler() {

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2,
                                  Throwable arg3) {
                Log.i("loginByAsyncHttpPost", "请求失败：" + new String(arg2));
                Toast.makeText(context,"请求失败：loginByAsyncHttpPost" + new String(arg2),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                Log.i("loginByAsyncHttpPost", "请求成功：" + new String(arg2));
                Toast.makeText(context,"请求成功：loginByAsyncHttpPost"  ,Toast.LENGTH_SHORT).show();

            }
        });
    }

    //AsyncHttpClient上传文件
    //params.put(profile_picture, new File(/sdcard/pictures/pic.jpg));
}
