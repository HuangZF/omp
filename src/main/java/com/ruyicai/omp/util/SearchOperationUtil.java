package com.ruyicai.omp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SearchOperationUtil {

	@SuppressWarnings("unchecked")
    public static Map<String, Object> getSqlConditionsMap(JqGridSearchTo jqGridSearchTo) {
		Map<String,Object> conditions = new HashMap<String,Object>();
		List<JqGridSearchDetailTo> rules = jqGridSearchTo.getRules();
		String field = null;
        String data = null;
		if(rules!=null&&rules.size()!=0){
			conditions = new HashMap<String,Object>();
			for(JqGridSearchDetailTo to : rules){
				if(to.getData()!=null && to.getData().trim().length()!=0){
				    // 获取查询值，模糊查询时需要转换特殊字符
				    // 模糊查询：包含'cn',不包含'nc',开始于'bw',不开始于'bn',结束于'ew',不结束于'en'
				    if(to.getOp().trim().equals("cn") || to.getOp().trim().equals("nc")
				            || to.getOp().trim().equals("bw") || to.getOp().trim().equals("bn")
				            || to.getOp().trim().equals("ew") || to.getOp().trim().equals("en")){
				        data = replaceSqlLike(to.getData().trim());
				    }else{
				        data = to.getData().trim();
				    }
					if(to.getOp().trim().equals("eq")||to.getOp().trim().equals("cn")) {
						//操作符分�? �?like，具体要配置在sqlmap�?
						if("AND".equalsIgnoreCase(jqGridSearchTo.getGroupOp())){
                            conditions.put(to.getField().trim(), data);
						}else if("OR".equalsIgnoreCase(jqGridSearchTo.getGroupOp())){
							if(conditions.containsKey(to.getField().trim())){
								((List<String>)conditions.get(to.getField().trim())).add(data);
							} else {
								List<String> dataList = new ArrayList<String>();
								dataList.add(data);
								conditions.put(to.getField().trim(), dataList);
							}
						}					
					}else {
						//�?��非等于和包含的情况名称前面加上比较标识，如小于创建时间即为ltcreateDate，在sqlmap中传递的参数名要对上，�?且运算符要对�?
						//jqgrid默认的标识对应的是：
						//等于'eq',不等�?ne',小于'lt',小于等于'le',大于'gt',大于等于'ge',�?���?bw',不开始于'bn',属于'in',不属�?ni',结束�?ew',不结束于'en',包含'cn',不包�?nc'
						//常用的为：等于�?小于等于、大于等于�?包含，一般就这四种需求�?
						//TODO 日期类型可能�?��特别判断，后续处�?
                        // 编辑查询字段（比较标识+比较字段）
					    field = to.getOp().trim()+to.getField().trim();
					    // 编辑查询条件
                        if("AND".equalsIgnoreCase(jqGridSearchTo.getGroupOp())){
                            // 且运算时设置查询条件（存在相同条件时覆盖前面的条件）
                            conditions.put(field, data);
                        }else if("OR".equalsIgnoreCase(jqGridSearchTo.getGroupOp())){
                            // 或运算时设置查询条件（存在相同条件时组成数组）
                            if(conditions.containsKey(field)){
                                ((List<String>)conditions.get(field)).add(data);
                            } else {
                                List<String> dataList = new ArrayList<String>();
                                dataList.add(data);
                                conditions.put(field, dataList);
                            }
                        }
					} 				
				}
			}
		}
		return conditions;		
	}

	/*
	 * 转换模糊查询特殊字符。
	 * @param sql 模糊查询SQL
	 * @return 转换后SQL
	 */
	private static String replaceSqlLike(String sql) {
	    if(sql == null || "".equals(sql)){
	        return sql;
	    }else{
            // 2012-07-04 CHL UPDATE 【bug1496】特殊字符查询  START
//	        return sql.replace("/", "//").replace("'", "''").replace("%", "/%");
            return sql.replace("/", "//").replace("'", "''").replace("%", "/%").replace("_", "/_");
            // 2012-07-04 CHL UPDATE 【bug1496】特殊字符查询  END
	    }
	}
}
