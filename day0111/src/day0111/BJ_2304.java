package day0111;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2304 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int[] arr = new int[1002];

        int N = sc.nextInt();
        int arr_length = 0;
        for(int i=0; i<N; i++) {
            int L = sc.nextInt();
            int H = sc.nextInt();
            // ���� ������ �ִ� ���� ã��
            if(arr_length < L) {
            	arr_length = L;
            }
            // �迭 �ε����� ���̸� ������ ����
            for(int j=0; j<arr_length+1; j++) {
                arr[L] = H;
            }
        }
        
        // ������ �ִ��� ������ �ε��� ã��
        int max_idx = 0;
        int max_H = 0;
        for(int x=0; x<arr_length+1; x++) {
        	if(arr[x] > max_H) {
        		max_H = arr[x];
        		max_idx = x;
        	}
        }
        
        int sum = 0;
        
        // �ִ� �ε��� �������� ���� �ּҸ��� ���ϱ�
        for(int i=1; i<=max_idx; i++) {
        	if(arr[i-1] > arr[i]) {
        		arr[i] = arr[i-1];
        	}
        	sum += arr[i-1];
        }

        
        // �ִ� �ε��� �������� ���� �ּҸ��� ���ϱ�
        for(int j=arr_length; j>max_idx; j--) {
        	if(arr[j] < arr[j+1]) {
        		arr[j] = arr[j+1];
        	}
        	sum += arr[j];
        }
        sum += arr[max_idx];

        
        System.out.println(sum);
    }
}