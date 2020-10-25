package guimodule;

import java.util.*;

public class builtInSort {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		Random rand = new Random();

		for (int i = 0; i < 5; i++) {
			nums.add(rand.nextInt(100));
		}

		Collections.sort(nums);

		System.out.println(nums.toString());
		
		
	}
}
