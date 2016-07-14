package cn.cauc.schedule;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.sql.Statement;

import cn.cauc.db.JDBCConnect;

public class ScheduleSpider {
	private static final int poolSize = 5;
	private static  ScheduledExecutorService cauc_keyword_info_scheduler =  Executors.newScheduledThreadPool(poolSize);
	private static  ScheduledExecutorService cauc_friendcircle_userinfo_scheduler =  Executors.newScheduledThreadPool(poolSize);
	private static  ScheduledExecutorService cauc_warningman_weibo_scheduler =  Executors.newScheduledThreadPool(poolSize);
	
	private static final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
	 // TODO ip放到外部属性文件中定义
	private static final String openSpiderUrl = "http://10.109.243.244:6800/schedule.json"; 
	
	/**
	 * 周期性启动运行爬虫
	 * @param nvps    爬虫运行参数 
	 * @param delay   周期运行延时
	 * @param unit    延时时间单位
	 * @return  返回预定任务执行器服务
	 */
	public static ScheduledExecutorService scheduleOpenSpiderWithFixedDelay(final List<NameValuePair> nvps, long delay, TimeUnit unit) {
		ScheduledExecutorService scheduler = null;
		String spiderName = nvps.get(1).getValue();  //获取当前爬虫名称
		if (spiderName.equals("cauc_keyword_info")) scheduler = cauc_keyword_info_scheduler;
		else if (spiderName.equals("cauc_friendcircle_userinfo")) scheduler = cauc_friendcircle_userinfo_scheduler;
		else scheduler = cauc_warningman_weibo_scheduler;
		
		if (scheduler.isShutdown()) scheduler = Executors.newScheduledThreadPool(poolSize);
		
		scheduler.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				System.out.println(sf.format(new Date())+"线程："+Thread.currentThread().getName());
				try {
					SpiderOperation.openSpider(openSpiderUrl, nvps, true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 0, delay, unit);
		return scheduler;
	}
	
	
	/**
	 * 修改爬虫参数或运行周期后周期性运行爬虫
	 * @param changeableNvps     可以被修改的爬虫运行参数（其中爬虫名称参数不会改变）
	 * @param changeableDelay    可以被修改的运行周期延时
	 * @param unit               延时时间单位
	 */
	public static void scheduleSpiderWithFixedDelayByChangedArgs(List<NameValuePair> changeableNvps, long changeableDelay, TimeUnit unit) {
		String spiderName = changeableNvps.get(1).getValue();  //获取当前爬虫名称
		ScheduledExecutorService scheduler = null;
		if (spiderName.equals("cauc_keyword_info")) scheduler = cauc_keyword_info_scheduler;
		else if (spiderName.equals("cauc_friendcircle_userinfo")) scheduler = cauc_friendcircle_userinfo_scheduler;
		else scheduler = cauc_warningman_weibo_scheduler;
		
		//关闭当前使用旧参数运行的爬虫
		scheduler.shutdown();
		
		//启动使用新参数运行的爬虫
		if (spiderName.equals("cauc_keyword_info")) cauc_keyword_info_scheduler = scheduleOpenSpiderWithFixedDelay(changeableNvps, changeableDelay, unit);
		else if (spiderName.equals("cauc_friendcircle_userinfo")) cauc_friendcircle_userinfo_scheduler = scheduleOpenSpiderWithFixedDelay(changeableNvps, changeableDelay, unit);
		else cauc_warningman_weibo_scheduler = scheduleOpenSpiderWithFixedDelay(changeableNvps, changeableDelay, unit);
	}

	
	// TODO 启动获取cookie模块及相应的crontab定时任务，写到调用页面中！！
	//ExecuteShell.executeShell("/home/hadoop_user/scrapy-weibospider-mysql/cookie_fetch_periodically.sh");
	
	// TODO ajax轮询检测flag为1
	
	
	/**
	 * 爬虫系统启动
	 * @param spiderArgs 启动各个爬虫所需的参数
	 * @return 启动成功，返回true
	 */
	@SuppressWarnings("unchecked")
	public static boolean startSpider(List<Map<String, Object>> spiderArgsList) {
		// TODO 检测到任务成功执行后，根据参数依次启动所有爬虫任务
		for (Map<String, Object> map : spiderArgsList) {
			scheduleOpenSpiderWithFixedDelay((List<NameValuePair>)map.get("spiderNvps"), (long)map.get("delay"), (TimeUnit)map.get("unit"));
		}
		return true;
	}
	
	
	/**
	 * 爬虫系统关闭
	 * @return 关闭成功，返回true
	 */
	public static boolean shutdownSpider() {
		// TODO 更新cauc_parameters表中的flag字段为0,增加mybatis的sql映射语句
		
		// 关闭crontab定时任务
		ExecuteShell.executeShell("/home/hadoop_user/scrapy-weibospider-mysql/cookie_crontab_close.sh");
		// 依次关闭三个爬虫
		cauc_keyword_info_scheduler.shutdown();
		cauc_friendcircle_userinfo_scheduler.shutdown(); 
		cauc_warningman_weibo_scheduler.shutdown();
		return true;
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//cauc_keyword_info参数
		List<NameValuePair> cauc_keyword_info_nvps = new ArrayList<>();
		cauc_keyword_info_nvps.add(new BasicNameValuePair("project", "weibospider"));
		cauc_keyword_info_nvps.add(new BasicNameValuePair("spider", "cauc_keyword_info"));
		cauc_keyword_info_nvps.add(new BasicNameValuePair("interval", "3600")); 
		
		//cauc_warningman_weibo参数
		List<NameValuePair> cauc_warningman_weibo_nvps = new ArrayList<>();
		cauc_warningman_weibo_nvps.add(new BasicNameValuePair("project", "weibospider"));
		cauc_warningman_weibo_nvps.add(new BasicNameValuePair("spider", "cauc_warningman_weibo"));
		cauc_warningman_weibo_nvps.add(new BasicNameValuePair("start_time", "2015-02-01"));  //设置start_time起始时间
		cauc_warningman_weibo_nvps.add(new BasicNameValuePair("interval", "86400")); 
		//scheduleOpenSpiderWithFixedDelay(cauc_warningman_weibo_nvps, 1800, TimeUnit.SECONDS);
		
		//cauc_friendcircle_userinfo参数
		List<NameValuePair> cauc_friendcircle_userinfo_nvps = new ArrayList<>();
		cauc_friendcircle_userinfo_nvps.add(new BasicNameValuePair("project", "weibospider"));
		cauc_friendcircle_userinfo_nvps.add(new BasicNameValuePair("spider", "cauc_friendcircle_userinfo"));
		cauc_friendcircle_userinfo_nvps.add(new BasicNameValuePair("start_time", "2015-02-01"));  //设置start_time起始时间
		cauc_friendcircle_userinfo_nvps.add(new BasicNameValuePair("interval", "86400"));  
		//scheduleOpenSpiderWithFixedDelay(cauc_friendcircle_userinfo_nvps, 1800, TimeUnit.SECONDS);
		
		//Thread.sleep(5000);
		
		List<NameValuePair> cauc_friendcircle_userinfo_nvps1 = new ArrayList<>();
		cauc_friendcircle_userinfo_nvps1.add(new BasicNameValuePair("project", "weibospider"));
		cauc_friendcircle_userinfo_nvps1.add(new BasicNameValuePair("spider", "cauc_friendcircle_userinfo"));
		cauc_friendcircle_userinfo_nvps1.add(new BasicNameValuePair("start_time", "2015-05-01"));  //设置start_time起始时间
		//scheduleSpiderWithFixedDelayByChangedArgs(cauc_friendcircle_userinfo_nvps1, 1800, TimeUnit.SECONDS);
		
		
		//cauc_friendcircle_userinfo_scheduler.shutdown(); //关闭该周期性爬虫调度
		
		// 测试爬虫任务的启动
		List<Map<String, Object>> spiderArgsList = new ArrayList<Map<String,Object>>();
		Map<String,Object> map1 = new HashMap<>(), map2 = new HashMap<>();
		map1.put("spiderNvps", cauc_friendcircle_userinfo_nvps);
		map1.put("delay", 1800l);
		map1.put("unit", TimeUnit.SECONDS);
		
		map2.put("spiderNvps", cauc_keyword_info_nvps);
		map2.put("delay", 1800l);
		map2.put("unit", TimeUnit.SECONDS);
		
		spiderArgsList.add(map1);
		spiderArgsList.add(map2);
		
		//startSpider(spiderArgsList);
	}
	
}
