package cn.cauc.schedulecopy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.sql.Statement;

import cn.cauc.db.JDBCConnect;

public class ScheduleSpider {
	private static final ScheduledExecutorService scheduler =  Executors.newScheduledThreadPool(10);
	private static final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final String openSpiderUrl = "http://10.109.243.244:6800/schedule.json";
	private static final String closeSpiderUrl = "http://10.109.243.244:6800/cancel.json";
	private static Connection conn = null;
	
	/**
	 * 周期性运行爬虫
	 * @param delay   周期运行延时
	 * @param unit    延时时间单位
	 */
	public static void scheduleOpenSpiderWithFixedDelay(final List<NameValuePair> nvps, long delay, TimeUnit unit) {
			scheduler.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				System.out.println(sf.format(new Date())+"线程："+Thread.currentThread().getName());
				try {
					
					System.out.println("spider name:"+nvps.get(1).getValue());
					String spiderName = nvps.get(1).getValue();  //获取nvps参数中的爬虫名字
					String jobId = SpiderOperation.openSpider(openSpiderUrl, nvps, true);
					System.out.println("opening spider jobid:" + jobId);
					String param_key = spiderName + "_jobid";
					conn =  JDBCConnect.getConnection();
					Statement stmt = conn.createStatement();
					String sql = "update cauc_parameters set param_value='" + jobId + "' where param_key='" + param_key + "'";
					stmt.executeUpdate(sql);
					conn.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 0, delay, unit);
	}
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//cauc_keyword_info参数
		List<NameValuePair> cauc_keyword_info_nvps = new ArrayList<>();
		cauc_keyword_info_nvps.add(new BasicNameValuePair("project", "weibospider"));
		cauc_keyword_info_nvps.add(new BasicNameValuePair("spider", "cauc_keyword_info")); 
		
		//cauc_warningman_weibo参数
		List<NameValuePair> cauc_warningman_weibo_nvps = new ArrayList<>();
		cauc_warningman_weibo_nvps.add(new BasicNameValuePair("project", "weibospider"));
		cauc_warningman_weibo_nvps.add(new BasicNameValuePair("spider", "cauc_warningman_weibo"));
		cauc_warningman_weibo_nvps.add(new BasicNameValuePair("start_time", "2015-02-01"));  //设置start_time起始时间
		//scheduleOpenSpiderWithFixedDelay(cauc_warningman_weibo_nvps, 1800, TimeUnit.SECONDS);
		
		//cauc_friendcircle_userinfo参数
		List<NameValuePair> cauc_friendcircle_userinfo_nvps = new ArrayList<>();
		cauc_friendcircle_userinfo_nvps.add(new BasicNameValuePair("project", "weibospider"));
		cauc_friendcircle_userinfo_nvps.add(new BasicNameValuePair("spider", "cauc_friendcircle_userinfo"));
		cauc_friendcircle_userinfo_nvps.add(new BasicNameValuePair("start_time", "2015-02-01"));  //设置start_time起始时间
		
		scheduleOpenSpiderWithFixedDelay(cauc_friendcircle_userinfo_nvps, 1800, TimeUnit.SECONDS);
		
		//Thread.sleep(5000);
		
		scheduler.shutdown(); //关闭该周期性爬虫调度
		
	}
	
}
