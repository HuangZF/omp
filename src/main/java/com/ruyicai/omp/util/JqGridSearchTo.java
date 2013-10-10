package com.ruyicai.omp.util;

import java.io.Serializable;
import java.util.List;

public class JqGridSearchTo implements Serializable {
	private static final long serialVersionUID = 4948250362203275210L;
	private String groupOp;     //多字段查询时分组类型，主要是AND或�?OR   
    private List<JqGridSearchDetailTo> rules; //多字段查询时候，查询条件的集�?         
       
    public JqGridSearchTo(){   
           
    }

	public String getGroupOp() {
		return groupOp;
	}

	public void setGroupOp(String groupOp) {
		this.groupOp = groupOp;
	}

	public List<JqGridSearchDetailTo> getRules() {
		return rules;
	}

	public void setRules(List<JqGridSearchDetailTo> rules) {
		this.rules = rules;
	}
}
