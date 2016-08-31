package com.example.xm.zhoubianyouofour.dest.entity;


import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class CityTitleBean {

    /**
     * code : 1000
     * message : 请求成功
     * content : [{"name":"热门","areaCode":0,"listType":"all"},{"name":"周边","areaCode":1,"listType":"around"},{"name":"江苏","areaCode":"320000","listType":"province"},{"name":"上海","areaCode":"310000","listType":"province"},{"name":"云南","areaCode":"530000","listType":"province"},{"name":"福建","areaCode":"350000","listType":"province"},{"name":"浙江","areaCode":"330000","listType":"province"},{"name":"澳门","areaCode":"820000","listType":"province"},{"name":"香港","areaCode":"810000","listType":"province"},{"name":"海南","areaCode":"460000","listType":"province"},{"name":"北京","areaCode":"110000","listType":"province"},{"name":"广东","areaCode":"440000","listType":"province"},{"name":"四川","areaCode":"510000","listType":"province"},{"name":"湖南","areaCode":"430000","listType":"province"},{"name":"台湾","areaCode":"710000","listType":"province"},{"name":"陕西","areaCode":"610000","listType":"province"},{"name":"重庆","areaCode":"500000","listType":"province"},{"name":"安徽","areaCode":"340000","listType":"province"},{"name":"广西","areaCode":"450000","listType":"province"},{"name":"湖北","areaCode":"420000","listType":"province"},{"name":"天津","areaCode":"120000","listType":"province"},{"name":"山东","areaCode":"370000","listType":"province"},{"name":"贵州","areaCode":"520000","listType":"province"},{"name":"江西","areaCode":"360000","listType":"province"},{"name":"河南","areaCode":"410000","listType":"province"},{"name":"辽宁","areaCode":"210000","listType":"province"},{"name":"山西","areaCode":"140000","listType":"province"}]
     */

    private int code;
    private String message;
    /**
     * name : 热门
     * areaCode : 0
     * listType : all
     */

    private List<ContentBean> content;

    public static CityTitleBean objectFromData(String str) {

        return new Gson().fromJson(str, CityTitleBean.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean implements Serializable {
        private String name;
        private int areaCode;
        private String listType;

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(int areaCode) {
            this.areaCode = areaCode;
        }

        public String getListType() {
            return listType;
        }

        public void setListType(String listType) {
            this.listType = listType;
        }
    }
}
