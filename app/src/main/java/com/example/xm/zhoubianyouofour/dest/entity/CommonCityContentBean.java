package com.example.xm.zhoubianyouofour.dest.entity;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class CommonCityContentBean {


    /**
     * code : 1000
     * message : 请求成功
     * content : {"hotScenic":[{"scenicId":"1035","scenicName":"亚龙湾","mudiPic":"http://cdn6.jinxidao.com/uploads/201511/564aa1300ddd7.jpg"},{"scenicId":"1356","scenicName":"海棠湾","mudiPic":"http://cdn6.jinxidao.com/uploads/201510/5625ad74b2088.jpg"},{"scenicId":"1027","scenicName":"三亚湾","mudiPic":"http://cdn6.jinxidao.com/uploads/201510/5625ad69d4ebf.jpg"},{"scenicId":"1357","scenicName":"大东海","mudiPic":"http://cdn6.jinxidao.com/uploads/201510/5625ad6fad9e0.jpg"}],"hotCity":[{"areaCode":"460200","cityName":"三亚","pinYin":"SanYa","pic":"http://cdn6.jinxidao.com/uploads/201510/5624c17331ce0.jpg","showPic":0},{"areaCode":"460100","cityName":"海口","pinYin":"HaiKou","pic":"","showPic":0},{"areaCode":"469000","cityName":"万宁","pinYin":"WanNing","pic":"","showPic":0},{"areaCode":"461700","cityName":"陵水","pinYin":"LingShui","pic":"","showPic":0},{"areaCode":"461800","cityName":"保亭","pinYin":"BaoTing","pic":"","showPic":0},{"areaCode":"460700","cityName":"琼海","pinYin":"QiongHai","pic":"","showPic":0},{"areaCode":"461500","cityName":"乐东","pinYin":"LeDong","pic":"","showPic":0},{"areaCode":"461200","cityName":"临高","pinYin":"LinGao","pic":"","showPic":0}]}
     */

    private int code;
    private String message;
    private ContentBean content;

    public static CommonCityContentBean objectFromData(String str) {

        return new Gson().fromJson(str, CommonCityContentBean.class);
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

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * scenicId : 1035
         * scenicName : 亚龙湾
         * mudiPic : http://cdn6.jinxidao.com/uploads/201511/564aa1300ddd7.jpg
         */

        private List<HotScenicBean> hotScenic;
        /**
         * areaCode : 460200
         * cityName : 三亚
         * pinYin : SanYa
         * pic : http://cdn6.jinxidao.com/uploads/201510/5624c17331ce0.jpg
         * showPic : 0
         */

        private List<HotCityBean> hotCity;

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public List<HotScenicBean> getHotScenic() {
            return hotScenic;
        }

        public void setHotScenic(List<HotScenicBean> hotScenic) {
            this.hotScenic = hotScenic;
        }

        public List<HotCityBean> getHotCity() {
            return hotCity;
        }

        public void setHotCity(List<HotCityBean> hotCity) {
            this.hotCity = hotCity;
        }

        public static class HotScenicBean {
            private String scenicId;
            private String scenicName;
            private String mudiPic;

            public static HotScenicBean objectFromData(String str) {

                return new Gson().fromJson(str, HotScenicBean.class);
            }

            public String getScenicId() {
                return scenicId;
            }

            public void setScenicId(String scenicId) {
                this.scenicId = scenicId;
            }

            public String getScenicName() {
                return scenicName;
            }

            public void setScenicName(String scenicName) {
                this.scenicName = scenicName;
            }

            public String getMudiPic() {
                return mudiPic;
            }

            public void setMudiPic(String mudiPic) {
                this.mudiPic = mudiPic;
            }
        }

        public static class HotCityBean implements Serializable{
            private String areaCode;
            private String cityName;
            private String pinYin;
            private String pic;
            private int showPic;

            public static HotCityBean objectFromData(String str) {

                return new Gson().fromJson(str, HotCityBean.class);
            }

            public String getAreaCode() {
                return areaCode;
            }

            public void setAreaCode(String areaCode) {
                this.areaCode = areaCode;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getPinYin() {
                return pinYin;
            }

            public void setPinYin(String pinYin) {
                this.pinYin = pinYin;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getShowPic() {
                return showPic;
            }

            public void setShowPic(int showPic) {
                this.showPic = showPic;
            }
        }
    }
}
