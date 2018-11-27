package jx.com.day1.util;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetUtil {


    public static NetUtil instance;
    public static NetUtil getInstance(){
        if(instance == null){
            instance = new NetUtil();
        }
        return instance;
    }


    public interface CallBack<T>{
        void getload(T t);
    }


    public void getload(String myuri, final Class clazz, final CallBack callBack){
        new AsyncTask<String, Void, Object>() {
            @Override
            protected Object doInBackground(String... strings) {
                return getload(strings[0],clazz);
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                callBack.getload(o);
            }
        }.execute(myuri);
    }

    public <E> E getload(String myuri,Class clazz){
        E e = (E) new Gson().fromJson(getload(myuri), clazz);
        return e;
    }

    public String getload(String myuri){

        String result = "";
        try {
            URL url = new URL(myuri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int responseCode = connection.getResponseCode();
            if(responseCode == 200){
                result = stream(connection.getInputStream());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //转换字符串
    public String stream(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        for(String tmp = br.readLine(); tmp != null; tmp = br.readLine()){
            builder.append(tmp);
        }
        return builder.toString();
    }

}
