package demo.wuchunmei.com.bean;


import java.io.Serializable;

/**
 * 实体基类
 *
 */
public abstract class Entity  implements Comparable,Serializable {
	@Override
	public int compareTo(Object object) {
		if (this==object){
			return 0; 
		}
		return -1;
	}

}
