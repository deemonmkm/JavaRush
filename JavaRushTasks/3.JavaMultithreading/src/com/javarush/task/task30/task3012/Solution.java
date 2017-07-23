package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(2345678);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        String numberIn3 = Integer.toString(number, 3);
        StringBuilder sb = new StringBuilder(numberIn3);
        sb.reverse();
        int[] nums = new int[sb.length() + 1];
        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            nums[i] = sb.charAt(i);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 50) {
                newStr.append("- ").append((int) Math.pow(3, i)).append(" ");
                nums[i + 1] = nums[i + 1] + 1;
            } else if (nums[i] == 48) {
                //do-nothing
            } else if (nums[i] == 49) {
                newStr.append("+ ").append((int) Math.pow(3, i)).append(" ");
            } else if (nums[i] == 51) {
                nums[i + 1] = nums[i + 1] + 1;
            }
        }
        if (nums[nums.length-1] == 1) newStr.append("+ ").append((int) Math.pow(3, nums.length-1));

        System.out.println(number + " = " + newStr.toString());
    }
}