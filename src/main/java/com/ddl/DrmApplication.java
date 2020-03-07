package com.ddl;

import lombok.extern.java.Log;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@MapperScan("com.ddl.web.system.*.mapper")
@Log
public class DrmApplication {

	Random random=new Random(10000);

	public static void main(String[] args) {
		SpringApplication.run(DrmApplication.class, args);
		//new DrmApplication().initTask();
	}

	@PostConstruct
	void setDefaultTimezone() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
	}

	private void initTask(){
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				log.info("seed:"+random.nextInt(999999));
			}
		},100,100, TimeUnit.MILLISECONDS);
	}
}
