package zyh.com.bean.carshop02;

import java.util.List;

public class RightRlistBean {

    private String cid;

    private List<RightListBean> list;

    private String name;

    private String pcid;

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCid() {
        return this.cid;
    }

    public List<RightListBean> getList() {
        return list;
    }

    public void setList(List<RightListBean> list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPcid(String pcid) {
        this.pcid = pcid;
    }

    public String getPcid() {
        return this.pcid;
    }
}
