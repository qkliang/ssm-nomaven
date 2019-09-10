package com.lqk.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * @author liangqiankun
 * @date 2019年9月10日
 */
public class CalendarDemo {
	public static void main(String[] args) {
		String inputDate = "2019/09/10";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(dateFormat.parse(inputDate));
			
			calendar.add(Calendar.YEAR, 1);
			// 2020.09.10
			System.out.println(dateFormat.format(calendar.getTime()));
			
			calendar.add(Calendar.MONTH, 1);
			// 2020.10.10
			System.out.println(dateFormat.format(calendar.getTime()));
			
			calendar.add(Calendar.DATE, 1);
			// 2020.10.11
			System.out.println(dateFormat.format(calendar.getTime()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
