package com.ruyicai.omp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询条件处理类.
 * @author hzf
 *
 */
public class SearchOperationUtil {

	/**
	 * 将sql查询条件设置到map结构中.
	 * <p>jqgrid默认的标识对应的是：
			等于'eq',不等于ne',小于'lt',小于等于'le',大于'gt',大于等于'ge',开始于'bw',
			不开始于'bn',属于'in',不属于'ni',结束于'ew',不结束于'en',包含'cn',不包含'nc'
			日期类型可能需要特别判断，后续处理
			常用的为：等于、小于等于、大于等于、包含，一般就这四种需求
		</p>
	 * @param jqGridSearchTo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getSqlConditionsMap(JqGridSearchTo jqGridSearchTo) {
		Map<String,Object> conditions = new HashMap<String,Object>();
		List<JqGridSearchDetailTo> rules = jqGridSearchTo.getRules();
		String field = null;
		String data = null;
		if(rules != null && rules.size() != 0){
			conditions = new HashMap<String,Object>();
			for(JqGridSearchDetailTo to : rules){
				if(to.getData() != null && to.getData().trim().length() != 0){
					// 获取查询值，模糊查询时需要转换特殊字符
					if(to.getOp().trim().equals("cn") || to.getOp().trim().equals("nc")
							|| to.getOp().trim().equals("bw") || to.getOp().trim().equals("bn")
							|| to.getOp().trim().equals("ew") || to.getOp().trim().equals("en")){
						data = replaceSqlLike(to.getData().trim());
					}else{
						data = to.getData().trim();
					}
					if(to.getOp().trim().equals("eq") || to.getOp().trim().equals("cn")) {
						field = to.getField().trim();
					}else {
						// 非等于和包含的情况名称前面加上比较标识，如小于创建时间即为ltcreateDate，在sqlmap中传递的参数名要对上，而且运算符要对应
						// 编辑查询字段（比较标识+比较字段）
						field = to.getOp().trim()+to.getField().trim();
					}
					// 编辑查询条件
					// 操作符分and 与 or，具体要配置在sqlmap中
					if("AND".equalsIgnoreCase(jqGridSearchTo.getGroupOp())){
						// 且运算时设置查询条件(存在相同条件时覆盖前面的条件)
						conditions.put(field, data);
					}else if("OR".equalsIgnoreCase(jqGridSearchTo.getGroupOp())){
						if(conditions.containsKey(field)){
							// 或运算时设置查询条件(存在相同条件时组成数组)
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
			return sql.replace("/", "//").replace("'", "''").replace("%", "/%").replace("_", "/_");
		}
	}
}
