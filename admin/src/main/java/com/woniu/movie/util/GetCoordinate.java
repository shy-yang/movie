package com.woniu.movie.util;

import net.sf.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 功能描述:<br>
 * 〈地址转换成坐标〉
 *
 * @author Administrator
 * @create 2019/10/18
 * @since 1.0.0
 */
public class GetCoordinate {
    //高德地图地址坐标转换
    public String getLngLat(String address) throws Exception{
        StringBuffer json = new StringBuffer();
        try {
            URL u = new URL("http://restapi.amap.com/v3/geocode/geo?address="+address+"&output=JSON&key=7f4ffae4074e8b8e4d147190527a4b72");
            URLConnection yc = u.openConnection();
            //读取返回的数据
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(),"UTF-8"));
            String inputline = null;
            while((inputline=in.readLine())!=null){
                json.append(inputline);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonStr=json.toString();
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);

        //判断输入的位置点是否存在
        if(jsonObject.getJSONArray("geocodes").size()>0)
            return jsonObject.getJSONArray("geocodes").getJSONObject(0).get("location").toString();
        else
            return null;
    }
}
