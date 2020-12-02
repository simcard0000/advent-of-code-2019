package aoc2019;

import java.util.Scanner;

public class Main {
	
	static Scanner in = new Scanner(System.in);
	
	static int day1A() {
		int answer= 0;
		String line;
		while(in.hasNextLine()) {
			line = in.nextLine();
			if (!line.isEmpty() && !line.isBlank()) {
				int num = Integer.valueOf(line).intValue();
				answer += Math.floorDiv(num, 3) - 2;
			} else {
				break;
			}
		}
		return answer;
	}
	
	static int day1B() {
		int answer = 0;
		String line;
		while(in.hasNextLine()) {
			line = in.nextLine();
			if (!line.isEmpty() && !line.isBlank()) {
				int num = Integer.valueOf(line).intValue();
				int original = num;
				int finalNum = 0;
				while (num >= 0) {
					finalNum += num;
					num = Math.floorDiv(num, 3) - 2;
				}
				answer += (finalNum - original);
			} else {
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		
		//System.out.println("day1A answer: " + day1A());
		//System.out.println("day1B answer: " + day1B());
	}

}
