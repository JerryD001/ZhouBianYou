package com.example.xm.zhoubianyouofour.homepage.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class RecyclerBean {


    private int code;

    private List<ContentBean> content;

    public static RecyclerBean objectFromData(String str) {

        return new Gson().fromJson(str, RecyclerBean.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        private String tabName;
        private int requestKey;
        private int total;
        /**
         * productId : 11245
         * productName : 欢乐谷门票
         * productDescription : 华侨城新一代大型主题乐园，九大主题区：西班牙广场、魔幻城堡、冒险山、金矿镇、香格里拉雪域、飓风湾、阳光海岸、欢乐时光、玛雅水公园，100多个老少皆宜、丰富多彩的游乐项目。
         * productTitle : 欢乐谷门票，轻松畅享欢乐
         * productTitleContent : 深圳欢乐谷门票1张（日夜场通用）。
         * mImageUrl : http://cdn5.jinxidao.com/group1/M00/00/70/oYYBAFbyH-2AHT0hAAEusjkX-lY276.jpg
         * url600x360 : http://cdn5.jinxidao.com/group1/M00/00/70/oYYBAFbyH-2AHT0hAAEusjkX-lY276.jpg
         * url : http://cdn5.jinxidao.com/group1/M00/00/70/oYYBAFbyH-2AHT0hAAEusjkX-lY276.jpg
         * bigImageUrl : http://cdn5.jinxidao.com/group1/M00/00/6F/ooYBAFbyH--AKl1jAAEcTYd2rNs853.jpg
         * labelText : 门票
         * stateText : null
         * listPicNew : null
         * newFlagUrl : null
         * isReduce : false
         * retailPrice : 200
         * price : 120
         * originalPrice : 200
         * isNew : true
         * idsTagPropertyTheme : 67,68,72,73;21,65,116,155,364,371,427,443,454,459,467,474,476,504,513,523,534;54,61,260,341,364,523,543,568,755
         * flag : null
         * saledCount : 35263
         * provinceName : 广东
         * cityName : 深圳
         * scenicList : null
         * adress : 广东省深圳市南山区杜鹃山西街
         * coordinate : 113.999644517899,22.5434356927872
         * distance : 40073700
         * goodRate : 4.186
         * channelLinkId : 68399
         * type : 0
         * mUrl : null
         * tags : []
         * viewCount : 0
         * recommend : true
         */

        @SerializedName("content")
        private List<Data> databean;

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public String getTabName() {
            return tabName;
        }

        public void setTabName(String tabName) {
            this.tabName = tabName;
        }

        public int getRequestKey() {
            return requestKey;
        }

        public void setRequestKey(int requestKey) {
            this.requestKey = requestKey;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<Data> getDatabean() {
            return databean;
        }

        public void setDatabean(List<Data> databean) {
            this.databean = databean;
        }

        public static class Data {
            private long productId;
            private String productName;
            private String productDescription;
            private String productTitle;
            private String productTitleContent;
            private String mImageUrl;
            private String url600x360;
            private String url;
            private String bigImageUrl;
            private String labelText;
            private Object stateText;
            private Object listPicNew;
            private Object newFlagUrl;
            private boolean isReduce;
            private int retailPrice;
            private int price;
            private int originalPrice;
            private boolean isNew;
            private String idsTagPropertyTheme;
            private Object flag;
            private long saledCount;
            private String provinceName;
            private String cityName;
            private Object scenicList;
            private String adress;
            private String coordinate;
            private double distance;
            private double goodRate;
            private long channelLinkId;
            private int type;
            private Object mUrl;
            private int viewCount;
            private boolean recommend;
            private List<?> tags;

            public static Data objectFromData(String str) {

                return new Gson().fromJson(str, Data.class);
            }

            public long getProductId() {
                return productId;
            }

            public void setProductId(long productId) {
                this.productId = productId;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getProductDescription() {
                return productDescription;
            }

            public void setProductDescription(String productDescription) {
                this.productDescription = productDescription;
            }

            public String getProductTitle() {
                return productTitle;
            }

            public void setProductTitle(String productTitle) {
                this.productTitle = productTitle;
            }

            public String getProductTitleContent() {
                return productTitleContent;
            }

            public void setProductTitleContent(String productTitleContent) {
                this.productTitleContent = productTitleContent;
            }

            public String getMImageUrl() {
                return mImageUrl;
            }

            public void setMImageUrl(String mImageUrl) {
                this.mImageUrl = mImageUrl;
            }

            public String getUrl600x360() {
                return url600x360;
            }

            public void setUrl600x360(String url600x360) {
                this.url600x360 = url600x360;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getBigImageUrl() {
                return bigImageUrl;
            }

            public void setBigImageUrl(String bigImageUrl) {
                this.bigImageUrl = bigImageUrl;
            }

            public String getLabelText() {
                return labelText;
            }

            public void setLabelText(String labelText) {
                this.labelText = labelText;
            }

            public Object getStateText() {
                return stateText;
            }

            public void setStateText(Object stateText) {
                this.stateText = stateText;
            }

            public Object getListPicNew() {
                return listPicNew;
            }

            public void setListPicNew(Object listPicNew) {
                this.listPicNew = listPicNew;
            }

            public Object getNewFlagUrl() {
                return newFlagUrl;
            }

            public void setNewFlagUrl(Object newFlagUrl) {
                this.newFlagUrl = newFlagUrl;
            }

            public boolean isIsReduce() {
                return isReduce;
            }

            public void setIsReduce(boolean isReduce) {
                this.isReduce = isReduce;
            }

            public int getRetailPrice() {
                return retailPrice;
            }

            public void setRetailPrice(int retailPrice) {
                this.retailPrice = retailPrice;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(int originalPrice) {
                this.originalPrice = originalPrice;
            }

            public boolean isIsNew() {
                return isNew;
            }

            public void setIsNew(boolean isNew) {
                this.isNew = isNew;
            }

            public String getIdsTagPropertyTheme() {
                return idsTagPropertyTheme;
            }

            public void setIdsTagPropertyTheme(String idsTagPropertyTheme) {
                this.idsTagPropertyTheme = idsTagPropertyTheme;
            }

            public Object getFlag() {
                return flag;
            }

            public void setFlag(Object flag) {
                this.flag = flag;
            }

            public long getSaledCount() {
                return saledCount;
            }

            public void setSaledCount(long saledCount) {
                this.saledCount = saledCount;
            }

            public String getProvinceName() {
                return provinceName;
            }

            public void setProvinceName(String provinceName) {
                this.provinceName = provinceName;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public Object getScenicList() {
                return scenicList;
            }

            public void setScenicList(Object scenicList) {
                this.scenicList = scenicList;
            }

            public String getAdress() {
                return adress;
            }

            public void setAdress(String adress) {
                this.adress = adress;
            }

            public String getCoordinate() {
                return coordinate;
            }

            public void setCoordinate(String coordinate) {
                this.coordinate = coordinate;
            }

            public double getDistance() {
                return distance;
            }

            public void setDistance(double distance) {
                this.distance = distance;
            }

            public double getGoodRate() {
                return goodRate;
            }

            public void setGoodRate(double goodRate) {
                this.goodRate = goodRate;
            }

            public long getChannelLinkId() {
                return channelLinkId;
            }

            public void setChannelLinkId(long channelLinkId) {
                this.channelLinkId = channelLinkId;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public Object getMUrl() {
                return mUrl;
            }

            public void setMUrl(Object mUrl) {
                this.mUrl = mUrl;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }

            public boolean isRecommend() {
                return recommend;
            }

            public void setRecommend(boolean recommend) {
                this.recommend = recommend;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }
        }
    }
}
