package com.ruyicai.omp.util;

import org.apache.commons.lang.StringUtils;

public class StringBuilderUtil {
	/**
	 * 将对象属性字符串转化为数据库查询字符串。<p>
	 * i.e. orderByColumn="userId",orderByType="desc"将被转化为"user_id desc",
	 * 供后续传给sqlMap拼装order by 语句。
	 * @param orderByColumn 排序项
	 * @param orderByType 排序方式
	 * @return 排序字符串
	 */
	public static String getOrderByString(String orderByColumn, String orderByType){
		StringBuffer orderByStringBuffer = new StringBuffer();
		char[] upperCaseChars = new char[]{'A','B','C','D','E',
				'F','G','H','I','J',
				'K','L','M','N','O',
				'P','Q','R','S','T',
				'U','V','W','X','Y','Z'};
		int beginIndex=0;
		int endIndex=StringUtils.indexOfAny(orderByColumn.substring(beginIndex), upperCaseChars);
		if(endIndex==-1){
			orderByStringBuffer.append(orderByColumn);			
		}else{
			while(endIndex!=-1){
				orderByStringBuffer.append(orderByColumn.substring(beginIndex,endIndex).toLowerCase()).append("_");
				beginIndex = endIndex;
				endIndex = StringUtils.indexOfAny(orderByColumn.substring(beginIndex+1), upperCaseChars);
				if(endIndex!=-1){
					endIndex=beginIndex+endIndex+1;
				}				
			}
			orderByStringBuffer.append(orderByColumn.substring(beginIndex).toLowerCase());
		}
		orderByStringBuffer.append(" ").append(orderByType);
		return orderByStringBuffer.toString();
	}

}
