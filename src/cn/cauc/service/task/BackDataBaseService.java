package cn.cauc.service.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.cauc.util.TzBackSqlUtil;

//@Component("taskJob")  
public class BackDataBaseService {
	
	//@Scheduled(cron = "0 42 23 * * ?")
	@Scheduled(cron = "1/1 * * * * ?")
	public void task(){
		
		System.out.println("任务进行中...");
		//TzBackSqlUtil.backup();
	}
}
