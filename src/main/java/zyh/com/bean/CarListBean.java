package zyh.com.bean;

import java.util.List;

public class CarListBean {

    /**
     * commodityId : 4
     * commodityName : 佩佩防晕染眼线液笔
     * count : 3
     * pic : http://172.17.8.100/images/small/commodity/mzhf/cz/2/1.jpg
     * price : 19
     */

    private int commodityId;
    private String commodityName;
    private int count;
    private String pic;
    private int price;

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarListBean{" +
                "commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", count=" + count +
                ", pic='" + pic + '\'' +
                ", price=" + price +
                '}';
    }
}
