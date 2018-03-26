import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.Scanner;


public class VisualCalendar {
//		public static void main(String[] args){
//			
//			System.out.println("请输入日期(按照格式yyyy年MM月dd日):");
//			Scanner dateScanner = new Scanner(System.in);
//			
//			String tempDate = dateScanner.nextLine();
//			DateFormat tempDateDf = new SimpleDateFormat("yyyy年MM月dd日");
//			try {
//				java.util.Date date = tempDateDf.parse(tempDate);
//				Calendar calendar =new GregorianCalendar();
//				calendar.setTime(date);
//				int today = calendar.get(Calendar.DATE);
//				//System.out.print(today);
//				
//				calendar.set(Calendar.DATE, 1);
//				
//				//System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
//				int maxDay = calendar.getActualMaximum(Calendar.DATE);
//		
//			System.out.println("日\t一\t二\t三\t四\t五\t六");
//			
//			
//			for(int i = 1;i < calendar.get(Calendar.DAY_OF_WEEK);i++) {
//				System.out.print('\t');
//			}
//			
//			
//			for(int i = 1;i <= maxDay;i++) {
//				if(i == today) {
//					System.out.print("*");
//				}
//				System.out.print(i + "\t");
//				int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
//				if(weekDay == Calendar.SATURDAY) {
//					System.out.print('\n');
//				}
//				calendar.add(Calendar.DATE, 1);
//			}
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
}
