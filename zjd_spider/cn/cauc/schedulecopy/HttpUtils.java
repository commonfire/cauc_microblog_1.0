package cn.cauc.schedulecopy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtils {
	public static void main(String[] args) throws IOException {
		String url = "http://10.109.243.244:6800/schedule.json";
		List<NameValuePair> nvps = new ArrayList<>();
		nvps.add(new BasicNameValuePair("project", "weibospider"));
		nvps.add(new BasicNameValuePair("spider", "cauc_keyword_info"));
		JSONObject jsonObject = httpPost(url, nvps, true);
		String jobId = jsonObject.getString("jobid");
		System.out.println(jobId);
		
	}
	
	/**
	 * 发送http post请求
	 * @param url           请求的url地址
	 * @param nvps          post请求的参数
	 * @param needResponse  是否需要返回响应结果
	 * @return              返回响应的JSON数据
	 * @throws IOException 
	 */
	public static JSONObject httpPost(String url, List<NameValuePair> nvps, boolean needResponse) throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
		JSONObject jsonResult = null;
		if (nvps != null) httpPost.setEntity(new UrlEncodedFormEntity(nvps)); //设置post参数
		
		try {
			response = httpClient.execute(httpPost);
			if (200 == response.getStatusLine().getStatusCode()) {
				HttpEntity entity = response.getEntity();
				String str = EntityUtils.toString(entity,"utf-8");
				if (!needResponse) return null;
				jsonResult = JSONObject.fromObject(str);
				//System.out.println(str);
				EntityUtils.consume(entity);
			}
			else System.out.println(response.getStatusLine().getStatusCode());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			response.close();
		}
		return jsonResult;
	}
	
}
