package cn.cauc.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Thread1 {

public static void main(String[] args) {
	ExecutorService exec1 = Executors.newCachedThreadPool();
	exec1.execute(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	});
}
}
