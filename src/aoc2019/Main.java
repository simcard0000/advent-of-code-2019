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
		in.close();
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
		in.close();
		return answer;
	}
	
	static int day2A() {
		int answer = 0;
		String line = in.nextLine();
		//taking input line and making an array out of it:
		in.close();
		String[] codes = line.split(",");
		codes[1] = Integer.toString(12);
		codes[2] = Integer.toString(2);
		for (int i = 0; i < codes.length; i += 4) {
			if (codes[i].equals("1") || codes[i].equals("2")) {
				int outputPos = Integer.valueOf(codes[i+3]).intValue();
				int arg1Pos = Integer.valueOf(codes[i+1]).intValue();
				int arg2Pos = Integer.valueOf(codes[i+2]).intValue();
				int arg1 = Integer.valueOf(codes[arg1Pos]).intValue();
				int arg2 = Integer.valueOf(codes[arg2Pos]).intValue();
				if (codes[i].equals("1")) {
					codes[outputPos] = Integer.toString(arg1 + arg2);
				} else {
					codes[outputPos] = Integer.toString(arg1 * arg2);
				}
			} else if (codes[i].equals("99")) {
				break;
			}
		}
		answer = Integer.valueOf(codes[0]).intValue();
		return answer;
	}
	
	static int day2B() {
		int answer = 0;
		String line = in.nextLine();
		//taking input line and making an array out of it:
		in.close();
		String[] codes = line.split(",");
		String[] originalCodes = codes.clone();
		boolean foundAns = false;
		//finding the right inputs:
		for (int i = 0; i < 100; i++) {
			codes[1] = Integer.toString(i);
			for (int j = i + 1; j < 100; j++) {
				codes[2] = Integer.toString(j);
				for (int k = 0; k < codes.length; k +=4) {
					if (codes[k].equals("1") || codes[k].equals("2")) {
						int outputPos = Integer.valueOf(codes[k+3]).intValue();
						int arg1Pos = Integer.valueOf(codes[k+1]).intValue();
						int arg2Pos = Integer.valueOf(codes[k+2]).intValue();
						int arg1 = Integer.valueOf(codes[arg1Pos]).intValue();
						int arg2 = Integer.valueOf(codes[arg2Pos]).intValue();
						if (codes[k].equals("1")) {
							codes[outputPos] = Integer.toString(arg1 + arg2);
						} else {
							codes[outputPos] = Integer.toString(arg1 * arg2);
						}
					} else if (codes[k].equals("99")) {
						break;
					}
				}
				if (Integer.valueOf(codes[0]).intValue() == 19690720) {
					foundAns = true;
					answer = 100 * i + j;
					break;
				} 
				codes = originalCodes.clone();
				codes[1] = Integer.toString(i);
			}
			if (foundAns) {
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		//Comment out the respective print statement!
		
		//System.out.println("day1A answer: " + day1A());
		//System.out.println("day1B answer: " + day1B());
		//System.out.println("day2A answer: " + day2A());
		//System.out.println("day2B answer: " + day2B());
	}

}
