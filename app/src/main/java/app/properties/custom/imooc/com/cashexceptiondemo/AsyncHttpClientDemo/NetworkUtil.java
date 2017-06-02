package app.properties.custom.imooc.com.cashexceptiondemo.AsyncHttpClientDemo;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by hasee on 2017/6/2.
 */

  /**
 * 判断网络状态的工具类
 *
 */
public class NetworkUtil {

    /* 代码IP */
    private static String PROXY_IP = null;
    /* 代理端口 */
    private static int PROXY_PORT = 0;
    /**
     * 判断当前是否有网络连接
     *
     * @param context
     * @return
     */
    public static boolean isNetwork(Context context) {
        boolean network = isWifi(context);
        boolean mobilework = isMobile(context);
        if (!network && !mobilework) { // 无网络连接
            Log.i("NetworkUtil", "无网路链接！");
            Toast.makeText(context,"无网路链接",Toast.LENGTH_SHORT).show();

            return false;
        } else if (network == true && mobilework == false) { // wifi连接
            Log.i("NetworkUtil", "wifi连接！");
            Toast.makeText(context,"wifi连接",Toast.LENGTH_SHORT).show();

        } else { // 网络连接
            Log.i("NetworkUtil", "手机网路连接，读取代理信息！");
            readProxy(context); // 读取代理信息
            Toast.makeText(context,"手机网路连接，读取代理信息",Toast.LENGTH_SHORT).show();
            Toast.makeText(context,PROXY_IP,Toast.LENGTH_SHORT).show();
            Toast.makeText(context,PROXY_PORT,Toast.LENGTH_SHORT).show();

            return true;
        }
        return true;
    }

    /**
     * 读取网络代理
     *
     * @param context
     */
    private static void readProxy(Context context) {
        Uri uri = Uri.parse("content://telephony/carriers/preferapn");
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(uri, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            PROXY_IP = cursor.getString(cursor.getColumnIndex("proxy"));
            PROXY_PORT = cursor.getInt(cursor.getColumnIndex("port"));
        }
        cursor.close();
    }

    /**
     * 判断当前网络是否是wifi局域网
     *
     * @param context
     * @return
     */
    public static boolean isWifi(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (info != null) {
            return info.isConnected(); // 返回网络连接状态
        }
        return false;
    }

    /**
     * 判断当前网络是否是手机网络
     *
     * @param context
     * @return
     */
    public static boolean isMobile(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (info != null) {
            return info.isConnected(); // 返回网络连接状态
        }
        return false;
    }
}
