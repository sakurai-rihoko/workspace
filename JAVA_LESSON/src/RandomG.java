import acm.program.*;
import acm.util.*;
public class RandomG extends ConsoleProgram {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int SIDENUM = 6;//面数
	public void run(){
		int numDice = readInt("Number of dice:");//输入骰子数
		int maxRoll =numDice * SIDENUM;//最大点
		int numRolls = 0;
		//重复roll知道最大跳出
		while(true){
			int roll = rollDice(numDice);
			numRolls++;
			if (roll==maxRoll){break;}
			println("Rolled"+roll);
			
		}
		println("Rolled"+ maxRoll + "after" + numRolls + "times");
		
	}
	//roll点方法
	private int rollDice(int numDice){
		int total =0 ;
		for(int i = 0;i< numDice;i++){
			total = total + rgen.nextInt(1,6);
		}
		return total;
	}
	//引入随机数方法
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
}
