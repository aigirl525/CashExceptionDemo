package app.properties.custom.imooc.com.cashexceptiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import app.properties.custom.imooc.com.cashexceptiondemo.AsyncHttpClientDemo.AsyncHttpClientUtil;
import app.properties.custom.imooc.com.cashexceptiondemo.AsyncHttpClientDemo.NetworkUtil;


public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Button btnGet;
    private Button btnPost;
    private Button btnNetUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGet = (Button) findViewById(R.id.btnGet);
        btnPost = (Button) findViewById(R.id.btnPost);
        btnNetUtil = (Button) findViewById(R.id.btnNetUtil);
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
    }
}