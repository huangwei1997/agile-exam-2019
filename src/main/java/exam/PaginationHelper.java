package exam;

import java.util.List;

// TODO: 完成这个类

public class PaginationHelper<T> {
    private List<T> collection;
    private int itemsPerPage;

    public List<T> getCollection() {
        return collection;
    }

    public void setCollection(List<T> collection) {
        this.collection = collection;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * 构造函数包含
     * 1）数组collection，表示需要分页的所有元素
     * 2）数字itemsPerPage，表示每页的元素个数
     */
    public PaginationHelper(List<T> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * 返回页数
     */
    public int pageCount() {
        return (int) Math.ceil(itemCount()*1.0/itemsPerPage);
    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {
        if(pageIndex<0 || pageIndex>pageCount()-1){
            return -1;
        }
        if(pageIndex==pageCount()-1){
            return itemCount()-(pageCount()-1)*itemsPerPage;
        }
        return itemsPerPage;
    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex>itemCount()-1 || itemIndex<0){
            return -1;
        }
        return (int) (itemIndex*1.0/itemsPerPage);
    }
}