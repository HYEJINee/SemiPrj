package model;

import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("�ȳ� ���� �ٺ�  ����   ��̾���  �ƺ�ġ  �ٽú���ʹ� ����", " ");
		String[] keyWords = new String[st.countTokens()];

		int i = 0;
		while (st.hasMoreElements())

		{

			keyWords[i] = st.nextToken().trim();
			i++;
		}
		
		for( i =0;i<keyWords.length ;i++){
			System.out.print(keyWords[i]);
		}
	}

}
