package com.duker.core.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * http客户端请求
 * @author xiebq
 * @create 2019/8/16 0016
 * @since 1.0.0
 */
@Component
@Slf4j
public class HttpClientHelper {

    /**
     * 功能描述: <br>
     * 带参数GET请求
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/16 0016 下午 16:10
     */
    public String doGet(String url, Map<String, String> param){
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        try{
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null){
                for (String key : param.keySet()){
                    builder.addParameter(key,param.get(key));
                }

                URI uri = builder.build();
                // 创建http GET请求
                HttpGet httpGet = new HttpGet(uri);
                // 执行请求
                response = httpClient.execute(httpGet);
                if (response.getStatusLine().getStatusCode() == 200){
                    resultString = EntityUtils.toString(response.getEntity(),"UTF-8");
                }
            }
        }catch (Exception e){
            log.error("GET请求失败:{}",e);
        }finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                log.error("GET请求实例未关闭:{}",e);
            }
        }
        return  resultString;
    }

    /**
     * 功能描述: <br>
     * 不带参GET请求
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/16 0016 下午 16:28
     */
    public String doGet(String url){
        return  doGet(url, null);
    }

    /**
     * 功能描述: <br>
     * 带参数POST请求
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/16 0016 下午 16:31
     */
    public String doPost(String url, Map<String, String> param){
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try{
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
        }catch (Exception e){
            log.error("POST请求失败:{}",e);
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                log.error("POST实例未关闭:{}",e);
            }
        }
        return resultString;
    }

    /**
     * 功能描述: <br>
     * 未带参数POST请求
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/16 0016 下午 16:36
     */
    public String doPost(String url) {
        return doPost(url, null);
    }

    /**
     * 功能描述: <br>
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/10/22 0022 上午 10:18
     */
    public static String doPostJson(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                log.error("POST实例未关闭:{}",e);
            }
        }

        return resultString;
    }





}
