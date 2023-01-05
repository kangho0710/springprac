package com.ezen.demo;

public class homework {
	public static void main(String[] args) {
			int[] nums = {1,10,2,7,4};
			
			for(int i=0;i<nums.length;i++) {
				for(int j=i+1;j<nums.length;j++) {
					int tmp;
					int max = nums[i];
					int min = nums[j];
					if(max<min){
						tmp = max;
						min = max;
						max = tmp;
					}
					System.out.println(nums[i]);
				}
			}
			
//			for(int i=0;i<nums.length;i++) {
//				System.out.println(nums[i]);
//			}
		}
		
		
}
