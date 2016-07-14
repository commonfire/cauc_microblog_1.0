package cn.cauc.schedulecopy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import cn.cauc.db.JDBCConnect;

public class SpiderOperation {
	private static final String openSpiderUrl = "http://10.109.243.244:6800/schedule.json";
	private static final String closeSpiderUrl = "http://10.109.243.244:6800/cancel.json";
	private static Connection conn = null;
	
	/**
	 * 使用scrapyd JSON web service 启动爬虫
	 * @param url            请求爬虫启动的url地址
	 * @param nvps           post请求的参数
	 * @param needResponse   是否需要返回响应结果
	 * @return               返回爬虫启动后对应的jobId,用于关闭爬虫
	 * @throws IOException
	 */
	public static String openSpider(String url, List<NameValuePair> nvps, boolean needResponse) throws IOException {
		JSONObject jsonObject = HttpUtils.httpPost(url, nvps, needResponse);
		String jobId = jsonObject.getString("jobid");
		return jobId;
		
	}
	
	/** 
	 * TODO 此方法待完善，且暂时无用
	 * 使用scrapyd JSON web service 关闭爬虫
	 * @param url            请求爬虫关闭的url地址
	 * @param spiderName     待关闭的"爬虫的名字_jobid"，用于获取数据库中对应的jobid
	 * @param nvps           post请求的参数
	 * @param needResponse   是否需要返回响应结果
	 * @throws IOException 
	 */
	public static void closeSpider(String url, String spiderNameJobId, List<NameValuePair> nvps, boolean needResponse) throws IOException {
		conn =  JDBCConnect.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "select param_value from cauc_parameters where param_key='" + spiderNameJobId + "'";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			String jobId = rs.getString("param_value");
			System.out.println("closing jobId:" + jobId);
			nvps.add(new BasicNameValuePair("job", jobId));
			JSONObject jsonObject = HttpUtils.httpPost(url, nvps, needResponse);
			String status = jsonObject.getString("status");
			if (status.equals("ok")) System.out.println("爬虫成功关闭！！");
			else throw new IOException("爬虫关闭出现异常！！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		//启动爬虫并获取jobId
//		List<NameValuePair> nvps = new ArrayList<>();
//		nvps.add(new BasicNameValuePair("project", "weibospider"));
//		nvps.add(new BasicNameValuePair("spider", "cauc_keyword_info"));
//		
//		String jobId = openSpider(openSpiderUrl, nvps, true);
		
		//根据jobId关闭爬虫
		List<NameValuePair> nvps1 = new ArrayList<>();
		nvps1.add(new BasicNameValuePair("project", "weibospider"));
		closeSpider(closeSpiderUrl, "cauc_friendcircle_userinfo_jobid", nvps1, true);
	}
}
