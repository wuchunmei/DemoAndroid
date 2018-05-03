package demo.wuchunmei.com.base.entity;

import java.util.List;

/**
 * implement the interface if the item is expandable
 * /**
 * 作者：wuchunmei on 5/3/18 00:51
 * <p>
 * 邮箱：646812329@qq.com
 */

public interface IExpandable<T> {
    boolean isExpanded();
    void setExpanded(boolean expanded);
    List<T> getSubItems();

    /**
     * Get the level of this item. The level start from 0.
     * If you don't care about the level, just return a negative.
     */
    int getLevel();
}
