package app.properties.custom.imooc.com.cashexceptiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import app.properties.custom.imooc.com.cashexceptiondemo.AsyncHttpClientDemo.AsyncHttpClientUtil;
import app.properties.custom.imooc.com.cashexceptiondemo.AsyncHttpClientDemo.NetworkUtil;
import app.properties.custom.imooc.com.cashexceptiondemo.gson.GsonUtil;
import app.properties.custom.imooc.com.cashexceptiondemo.gson.JsonBean;


public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Button btnGet;
    private Button btnPost;
    private Button btnNetUtil;
    private Button btnGson1;
    private Button btnGson2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGet = (Button) findViewById(R.id.btnGet);
        btnPost = (Button) findViewById(R.id.btnPost);
        btnNetUtil = (Button) findViewById(R.id.btnNetUtil);
        btnGson1 = (Button) findViewById(R.id.btnGson1);
        btnGson2 = (Button) findViewById(R.id.btnGson2);
        //全局异常测试
       /* btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            btn.setText("error");
        }
        });*/
        final AsyncHttpClientUtil asyncHttpClientUtil = new AsyncHttpClientUtil(MainActivity.this);

        //网络请求测试
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncHttpClientUtil.loginByAsyncHttpGet();

            }
        });
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncHttpClientUtil.loginByAsyncHttpPost();

            }
        });
        //判断网络状态
        btnNetUtil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkUtil.isNetwork(MainActivity.this);
            }
        });
        //json转成单一实体对象
        btnGson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = asyncHttpClientUtil.loginByAsyncHttpGet();
                int position=json.indexOf("{");
                String jsonSub = json.substring(position);
                GsonUtil.Json2Obj( jsonSub, JsonBean.class);
            }
        });
        //json转成对象列表或者其他结构
        btnGson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GsonUtil.Json2ObjList(asyncHttpClientUtil.loginByAsyncHttpGet(), JsonBean.class);
            }
        });
    }
}