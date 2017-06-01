package app.properties.custom.imooc.com.cashexceptiondemo.AsyncHttpClientDemo;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.apache.http.Header;
/**
 * Created by hasee on 2017/5/25.
 */

public class AsyncHttpClientUtil {
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

            }

            @Override
            public void onFailure(int i, org.apache.http.Header[] headers, byte[] bytes, Throwable throwable) {
                 Log.i("loginByAsyncHttpGet", "请求失败： "+ new String(bytes));

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
                // TODO Auto-generated method stub
                Log.i("loginByAsyncHttpPost", "请求失败：" + new String(arg2));
            }

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                // TODO Auto-generated method stub
                Log.i("loginByAsyncHttpPost", "请求成功：" + new String(arg2));
            }
        });
    }
}
