package com.example.xm.zhoubianyouofour.homepage.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class HotBean {

    private int code;
    private int total;
    /**
     * productId : 23066
     * productName : 上海迪士尼乐园门票
     * productDescription : 2016年6月16日上海迪士尼乐园盛大开幕，这里充满创造力、冒险精神与无穷精彩的快乐天地，每个人都能在这里点亮心中奇梦。探索别具一格又令人难忘的六大主题园区，畅游这个神奇世界。
     * productTitle : 上海迪士尼乐园门票
     * productTitleContent : 上海迪士尼乐园6月16日盛大开幕，中国大陆首座迪士尼度假区。
     * mImageUrl : http://cdn5.jinxidao.com/group1/M00/02/49/oYYBAFdftKmAFsfUAAD1dDP048Q550.jpg
     * url600x360 : http://cdn5.jinxidao.com/group1/M00/02/49/oYYBAFdftKmAFsfUAAD1dDP048Q550.jpg
     * url : http://cdn5.jinxidao.com/group1/M00/02/49/oYYBAFdftKmAFsfUAAD1dDP048Q550.jpg
     * bigImageUrl : http://cdn5.jinxidao.com/group1/M00/02/49/ooYBAFdftK2ABwKdAAE3kQTC4rY365.jpg
     * labelText : 门票
     * stateText : 可订今日
     * listPicNew : null
     * newFlagUrl : http://cdn5.jinxidao.com/images/OfferInfo/60bca2f063634dac8e1422a21d4c620a.png
     * isReduce : true
     * retailPrice : 375
     * price : 375
     * originalPrice : 375
     * isNew : true
     * idsTagPropertyTheme : 67,68,72,73;338,511,558;154,722
     * flag : http://cdn5.jinxidao.com/images/OfferInfo/501091152a9b45578eee6fbb7dcd448b.png
     * saledCount : 3470
     * provinceName : 上海
     * cityName : 上海
     * scenicList : null
     * adress : 上海市上海市浦东新区黄赵路488
     * coordinate : -179.999989271164,-89.999994635582
     * distance : 40073700
     * goodRate : 4.828
     * channelLinkId : 165870
     * type : 0
     * mUrl : null
     * tags : []
     * viewCount : 0
     * recommend : true
     */

    private List<ContentBean> content;

    public static HotBean objectFromData(String str) {

        return new Gson().fromJson(str, HotBean.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
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
        private String stateText;
        private Object listPicNew;
        private String newFlagUrl;
        private boolean isReduce;
        private int retailPrice;
        private int price;
        private int originalPrice;
        private boolean isNew;
        private String idsTagPropertyTheme;
        private String flag;
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

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public long getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
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

        public String getStateText() {
            return stateText;
        }

        public void setStateText(String stateText) {
            this.stateText = stateText;
        }

        public Object getListPicNew() {
            return listPicNew;
        }

        public void setListPicNew(Object listPicNew) {
            this.listPicNew = listPicNew;
        }

        public String getNewFlagUrl() {
            return newFlagUrl;
        }

        public void setNewFlagUrl(String newFlagUrl) {
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

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public long getSaledCount() {
            return saledCount;
        }

        public void setSaledCount(int saledCount) {
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

        public void setDistance(int distance) {
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

        public void setChannelLinkId(int channelLinkId) {
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
