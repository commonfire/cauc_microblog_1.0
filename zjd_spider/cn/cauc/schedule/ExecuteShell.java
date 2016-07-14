package cn.cauc.schedule;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteShell {
	/**
	 * 执行shell脚本程序
	 * @param shellScriptFilename  shell脚本文件名
	 */
	public static void executeShell(String shellScriptFilename) {
		try {
			Process process = Runtime.getRuntime().exec(shellScriptFilename);
			// 获取shell返回流(字节流)
			BufferedInputStream in = new BufferedInputStream(process.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String lineStr = null;
			while ((lineStr = br.readLine()) != null) {
				System.out.println(lineStr);
			}
			br.close();
			in.close();
			System.out.println("shell scripts finished!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// 程序测试需要在服务器上，因为脚本在其上
		// String shellScriptFilename = "/home/hadoop_user/scrapy-weibospider-mysql/cookie_fetch_periodically.sh";
		// String shellScriptFilename = "/home/hadoop_user/scrapy-weibospider-mysql/cookie_crontab_close.sh";
		//ExecuteShell.executeShell(shellScriptFilename);
	}
}
