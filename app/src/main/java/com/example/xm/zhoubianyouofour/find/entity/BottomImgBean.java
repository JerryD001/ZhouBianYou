package com.example.xm.zhoubianyouofour.find.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class BottomImgBean {


    /**
     * code : 1000
     * message : 请求成功
     * content : {"recordCount":75,"themeList":[{"themeId":"613","title":"和风温泉小镇，暖暖好销魂","subTitle":"珠海御温泉，一天穿越盛唐&东瀛","description":"闲趣小汤镇，松石明月，柴门木屋，古风浓厚，御温泉既有盛唐的华贵style也有日式的清幽禅味。辽阔乡野、排排蕉林，踏着清脆的木屐，推开窗子，清鲜气息深入肺腑；夜晚星星点点，躺在华兴池来一个水中睡眠，或者体验下\u201c通泡\u201d的乐趣，六福汤、七颜汤、瀑布泉\u2026\u2026","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/5698962b882c8.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"726","title":"在海陵之角 放一个发呆假","subTitle":"发现海岛第三期：海陵岛","description":"海陵岛被评为\u201c中国十大最美海岛\u201d之一，四面环海，冬无严寒，夏无酷暑，四季如春,岛内有大角湾、马尾岛风景区、十里银滩、金沙滩风等风景区。","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/group1/M00/01/35/ooYBAFcZzIWAaEpWAADLaeyBoGw894.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"617","title":"中山有家超牛掰的\u201c温泉宾馆\u201d","subTitle":"邓小平亲笔题名！岭南派建筑大师设计！","description":"中山温泉宾馆绝对来头够大！\r\n1、各种名人伟人云集，建筑大师莫伯治先生设计，邓小平同志亲笔题名；\r\n2、东南亚风情，\u201c中国十大温泉\u201d之一，理疗和保健效果杠杠滴；\r\n3、中国内地第一家高尔夫球会；\r\n4、坐拥罗三妹山一流山景，邓小平也曾经登过这座山哦。","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/5698c0bcbf96f.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"725","title":"赴一趟阳光海滩之约","subTitle":"发现海岛第二期：上下川岛","description":"岛上风光迷人，有沙质优良的椰林海滩，有风光旖旎的小岛和海湾，有引人入胜的名胜古迹，有茂密的原始次生森林和动植物奇观以及品种齐全的海鲜珍品。","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/group1/M00/01/35/oYYBAFcZy_eACiYiAAIthyuq59E547.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"588","title":"周庄，吴侬软语阿婆茶香","subTitle":"喝一口黄酒，吃一大口的万三蹄","description":"周庄，春秋时期有\u201c摇城\u201d之称。一声吴歌响起，船桨吱呀，穿过双桥，摇出一个水上的周庄。在这里找一间临河客栈住上一晚，在人潮退散后独享古镇的清晨和黄昏。晨雾缭绕，白墙黛瓦如画如诗，漫步蜿蜒的青石板路，穿过古桥，找一间茶楼，喝一口黄酒，吃一大口的万三蹄\u2026\u2026","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/568dd5be24e76.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"724","title":"悠悠伶仃 云淡风轻","subTitle":"发现海岛第一期：外伶仃岛","description":"外伶仃岛地处珠江入海口，与香港一水之隔，是广东唯一能看到香港市区的海岛。爬上伶仃峰，可从上往下鸟瞰全岛。你还可在海滨泳场游泳，随意享用价廉物美的海鲜和烧烤，在此度过一个悠闲完美的假期。 ","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/group1/M00/01/35/oYYBAFcZyjCAfEWBAAHMuPcIgyQ523.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"600","title":"一波吃货，已迷失在台北夜市","subTitle":"台北人气住宿推荐","description":"台北夜市，台北美食精髓的代表之一，最热闹的士林夜市、宁夏夜市，离101最近的饶河、通化夜市\u2026\u2026牛肉面、炸鸡排、芋园、蚵仔煎、大肠包小肠、甜不辣与天妇罗、花枝 、盐酥鸡，想想口水都已经流湿键盘，逛逛逛吃吃吃，你会爱上充满人情味的台北夜市！","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/56938711095e4.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"592","title":"原来白富美是这样炼成的！","subTitle":"如何过一个高逼格的周末？","description":"广州：\r\n来一场优雅的马术，骑马驰骋野外，英姿飒爽，逼格满满；畅游意大利山城美林湖，泡温泉，绿荫湖畔打高尔夫，休闲又惬意；\r\n\r\n惠州：\r\n体验真枪实弹射击，砰砰砰刺激又帅气，晒朋友圈绝对收获1W赞啦；玩转南昆山十字水，全球生态度假村50强哟，在竹林与山花间来一场森林浴\u2026\u2026","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/568f71b043f3b.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"586","title":"有一种情怀叫香港电影","subTitle":"追随大片玩香港，探寻港片拍摄地","description":"第1站：旺角街道\u2014《旺角黑夜》\r\n狭窄街道，迷离灯光，吴彦祖扮演的杀手死于此。\r\n\r\n第2站：重庆大厦\u2014《重庆森林》\r\n林青霞、梁朝伟等，在这上演了一段纠缠。\r\n\r\n第3站：铜锣湾\u2014《花样年华》\r\n金雀餐厅，梁朝伟叼了根烟与张曼玉对坐着谈话。\r\n\r\n第4站：尖沙咀\u2014《阿飞正传》\r\n影片中活现了旧香港情调的皇后饭店，至今仍营业。","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/568ced794b7a8.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"513","title":"我在海南的艳阳里露着腰","subTitle":"全球第一条环岛高铁，3h玩转海南！","description":"你在北方的大炕上裹着貂，\r\n我在海南的艳阳里露着腰！\r\n海南岛西环高铁今年12月20日通车啦！与东环线闭合，3h环岛游一圈，沿线美景赏不停，海岛火山的遗迹，椰林环抱的村庄，冬天青绿的晚稻，星罗棋布的岛礁，茂密的雨林\u2026\u2026速度走起！","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/56654dc44c8a2.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"577","title":"2016，住过这些酒店才叫人生！","subTitle":"广东超貌美豪华酒店推荐","description":"2016，住过这些酒店才叫人生！\r\n四季酒店，98层高空，全透落地窗，躺在在云霄上，看羊城灯火璀璨；\r\n九龙湖，浪漫公主小镇，缤纷的欧洲建筑，转角就能遇到鲜花店、咖啡屋；\r\n候鸟水榕庄，不输巴厘岛的美景，畅享水疗SPA，看候鸟高飞\u2026\u2026","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/5684a845e763f.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"557","title":"竹林泡汤泉，穿洞入桃源","subTitle":"清远御竹轩汤泉，周末清肺暖身游","description":"广州这几天灰霾霾的，找个山清水秀的地方放松下啦！这里竹林青青，温泉水雾腾腾，晚上躺在临河木屋小别墅，听溪水声潺潺，住在大自然的感觉爽得不要不要滴！泡过温泉顺道畅游下洞天仙境，坐着游船穿梭溶洞，漫步悬空玻璃栈道，惊险又刺激~","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/567a4bc945e38.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"598","title":"私密室内温泉pk寒潮大boss！","subTitle":"对澡堂式温泉say no!","description":"阴雨寒潮天气，室内温泉绝对是首选啦！\r\n温泉小院，1室1汤，私密性超高，很适合情侣~\r\n下面来看看超赞的私汤：\r\n望谷温泉，每间房都接驳了温泉水哦，一边泡汤，一边270°饱览流溪河美景；\r\n三英温泉，在苍郁山林间泡着私汤，古法中药泡汤养生又滋润，蒸走疲劳\u2026\u2026","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/56936f5561378.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"571","title":"周末1日游top榜【亲子篇】","subTitle":"一周走一个，带宝贝玩转你的城市！","description":"萌萌哒的泰迪熊，淘气的PORORO，500种30000多只极地海洋动物，各种主题游玩绝对轻松博熊娃一乐~~各种补习班兴趣班塞满孩子\u201c脑门\u201d，周末记得带孩子去放松下~","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/5683801a518bd.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"526","title":"温泉战斗机！广深出发2h内","subTitle":"汕尾水底山，广东最大的温泉池区","description":"何为温泉中的战斗机？\r\n1、距离近！广深出发2h内！\r\n2、环境美！峡谷林溪、瀑布河流环绕！\r\n3、汤池多！68个汤池，有特色喂奶鱼池、漂流河、河岸别墅私汤等！\r\n4、美食赞！潮汕小吃盛宴，牛肉丸、蚝烙、咸茶\u2026\u2026\r\n5、景点棒！周边有莲花山、红海湾等！","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/5671535cda503.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"542","title":"广东温泉奢壕榜TOP8","subTitle":"寒潮来啦！土豪都爱去哪泡？","description":"1、金叶子温泉\u2014高山林海上的巴厘岛\r\n2、都喜泰丽\u2014泰式风情spa\r\n3、三英温泉\u2014古法药浴是一绝\r\n4、香江健康山谷\u2014\u201c七星级\u201d欧陆风情\r\n5、美林湖温泉\u2014\u201c意大利山城\u201d\r\n6、龙门地派\u2014唐式华贵，禅乐仙境\r\n7、南昆山云顶温泉\u2014森林氧吧，\u201c云顶\u201d私汤\r\n8、御温泉\u2014汉唐风情，穿越小汤镇","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/567278a77a5b2.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"525","title":"温泉禅修，脚步跟上灵魂","subTitle":"古刹南华寺祈福，圣水曹溪泡温泉","description":"生活喧嚣繁杂让人心累，不如到韶关南华寺祈福禅修，品味洒脱自在的惬意！这里是禅宗六祖惠能宏扬\u201c南宗禅法\u201d的发源地，传说大师曾在曹溪沐浴净身，一夜之间顿悟佛理，曹溪水因此而成为千年圣水。礼佛祈福泡温泉，很适合带爸妈走起！","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/5671537755739.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"529","title":"充满幸运和挑战的Macau！","subTitle":"到澳门来碰碰运气！","description":"澳门素有\u201c东方蒙特卡罗\u201d之称，兴旺的博彩业，为其繁荣发展注入无限活力，也吸引众多富豪娱乐于此。当然它也因其众多的名胜古迹、宗教建筑，澳门可是有非常多的教堂，走进它，感受它的虔诚和静谧神圣。中西合璧的澳门饮食文化，挑战你的味蕾；223米的澳门旅游塔，极速挑战60秒，整个澳门就在你脚下。澳门不大，一两天就可以徒步走完，赶紧飞来吧！","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/5694af1c8777b.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"548","title":"元阳梯田，摄影季即将到！","subTitle":"中国第45处世界遗产,傻瓜机也能拍大片！","description":"最佳观赏节：1月\u20143月，春节前后最佳\r\n被摄影家们称为世界上最壮丽的田园风光的元阳梯田，每年1月-3月期间，层叠起伏的梯田灌满了水，波光粼粼，银光闪闪，森林茫茫，云海漫漫，总是烟雨迷蒙，好似一幅水墨山水画，傻瓜机也能拍出风光大片哦。春节前后则最佳，此时极易看到云海。一般在元宵前后，当地野樱花、野木棉花、野桃花和棠梨花开，满山的红、白色，漂亮极了。","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/5673c4b66c7ce.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"546","title":"梅里雪山，转山转水转佛塔","subTitle":"据说只有神的宠儿，才能见到日照金山！","description":"最佳季节：1-2月\r\n最佳观赏点：飞来寺、雾浓顶观景台\r\n联游推荐：雨崩、虎跳峡、 普达措国家公园\r\n藏民们捻着念珠，握着转经筒，绕山朝拜，只为了心中的\u201c雪山之神\u201d。这里终年云雾围绕，传说中能看到卡瓦格博全景的人，一年都有好运，而能看到日照金山的人，更是神的宠儿！","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/56738117ed7b2.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""}]}
     */

    private int code;
    private String message;
    /**
     * recordCount : 75
     * themeList : [{"themeId":"613","title":"和风温泉小镇，暖暖好销魂","subTitle":"珠海御温泉，一天穿越盛唐&东瀛","description":"闲趣小汤镇，松石明月，柴门木屋，古风浓厚，御温泉既有盛唐的华贵style也有日式的清幽禅味。辽阔乡野、排排蕉林，踏着清脆的木屐，推开窗子，清鲜气息深入肺腑；夜晚星星点点，躺在华兴池来一个水中睡眠，或者体验下\u201c通泡\u201d的乐趣，六福汤、七颜汤、瀑布泉\u2026\u2026","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/5698962b882c8.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"726","title":"在海陵之角 放一个发呆假","subTitle":"发现海岛第三期：海陵岛","description":"海陵岛被评为\u201c中国十大最美海岛\u201d之一，四面环海，冬无严寒，夏无酷暑，四季如春,岛内有大角湾、马尾岛风景区、十里银滩、金沙滩风等风景区。","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/group1/M00/01/35/ooYBAFcZzIWAaEpWAADLaeyBoGw894.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"617","title":"中山有家超牛掰的\u201c温泉宾馆\u201d","subTitle":"邓小平亲笔题名！岭南派建筑大师设计！","description":"中山温泉宾馆绝对来头够大！\r\n1、各种名人伟人云集，建筑大师莫伯治先生设计，邓小平同志亲笔题名；\r\n2、东南亚风情，\u201c中国十大温泉\u201d之一，理疗和保健效果杠杠滴；\r\n3、中国内地第一家高尔夫球会；\r\n4、坐拥罗三妹山一流山景，邓小平也曾经登过这座山哦。","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/5698c0bcbf96f.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"725","title":"赴一趟阳光海滩之约","subTitle":"发现海岛第二期：上下川岛","description":"岛上风光迷人，有沙质优良的椰林海滩，有风光旖旎的小岛和海湾，有引人入胜的名胜古迹，有茂密的原始次生森林和动植物奇观以及品种齐全的海鲜珍品。","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/group1/M00/01/35/oYYBAFcZy_eACiYiAAIthyuq59E547.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"588","title":"周庄，吴侬软语阿婆茶香","subTitle":"喝一口黄酒，吃一大口的万三蹄","description":"周庄，春秋时期有\u201c摇城\u201d之称。一声吴歌响起，船桨吱呀，穿过双桥，摇出一个水上的周庄。在这里找一间临河客栈住上一晚，在人潮退散后独享古镇的清晨和黄昏。晨雾缭绕，白墙黛瓦如画如诗，漫步蜿蜒的青石板路，穿过古桥，找一间茶楼，喝一口黄酒，吃一大口的万三蹄\u2026\u2026","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/568dd5be24e76.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"724","title":"悠悠伶仃 云淡风轻","subTitle":"发现海岛第一期：外伶仃岛","description":"外伶仃岛地处珠江入海口，与香港一水之隔，是广东唯一能看到香港市区的海岛。爬上伶仃峰，可从上往下鸟瞰全岛。你还可在海滨泳场游泳，随意享用价廉物美的海鲜和烧烤，在此度过一个悠闲完美的假期。 ","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/group1/M00/01/35/oYYBAFcZyjCAfEWBAAHMuPcIgyQ523.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"600","title":"一波吃货，已迷失在台北夜市","subTitle":"台北人气住宿推荐","description":"台北夜市，台北美食精髓的代表之一，最热闹的士林夜市、宁夏夜市，离101最近的饶河、通化夜市\u2026\u2026牛肉面、炸鸡排、芋园、蚵仔煎、大肠包小肠、甜不辣与天妇罗、花枝 、盐酥鸡，想想口水都已经流湿键盘，逛逛逛吃吃吃，你会爱上充满人情味的台北夜市！","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/56938711095e4.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"592","title":"原来白富美是这样炼成的！","subTitle":"如何过一个高逼格的周末？","description":"广州：\r\n来一场优雅的马术，骑马驰骋野外，英姿飒爽，逼格满满；畅游意大利山城美林湖，泡温泉，绿荫湖畔打高尔夫，休闲又惬意；\r\n\r\n惠州：\r\n体验真枪实弹射击，砰砰砰刺激又帅气，晒朋友圈绝对收获1W赞啦；玩转南昆山十字水，全球生态度假村50强哟，在竹林与山花间来一场森林浴\u2026\u2026","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/568f71b043f3b.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"586","title":"有一种情怀叫香港电影","subTitle":"追随大片玩香港，探寻港片拍摄地","description":"第1站：旺角街道\u2014《旺角黑夜》\r\n狭窄街道，迷离灯光，吴彦祖扮演的杀手死于此。\r\n\r\n第2站：重庆大厦\u2014《重庆森林》\r\n林青霞、梁朝伟等，在这上演了一段纠缠。\r\n\r\n第3站：铜锣湾\u2014《花样年华》\r\n金雀餐厅，梁朝伟叼了根烟与张曼玉对坐着谈话。\r\n\r\n第4站：尖沙咀\u2014《阿飞正传》\r\n影片中活现了旧香港情调的皇后饭店，至今仍营业。","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/568ced794b7a8.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"513","title":"我在海南的艳阳里露着腰","subTitle":"全球第一条环岛高铁，3h玩转海南！","description":"你在北方的大炕上裹着貂，\r\n我在海南的艳阳里露着腰！\r\n海南岛西环高铁今年12月20日通车啦！与东环线闭合，3h环岛游一圈，沿线美景赏不停，海岛火山的遗迹，椰林环抱的村庄，冬天青绿的晚稻，星罗棋布的岛礁，茂密的雨林\u2026\u2026速度走起！","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/56654dc44c8a2.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"577","title":"2016，住过这些酒店才叫人生！","subTitle":"广东超貌美豪华酒店推荐","description":"2016，住过这些酒店才叫人生！\r\n四季酒店，98层高空，全透落地窗，躺在在云霄上，看羊城灯火璀璨；\r\n九龙湖，浪漫公主小镇，缤纷的欧洲建筑，转角就能遇到鲜花店、咖啡屋；\r\n候鸟水榕庄，不输巴厘岛的美景，畅享水疗SPA，看候鸟高飞\u2026\u2026","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/5684a845e763f.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"557","title":"竹林泡汤泉，穿洞入桃源","subTitle":"清远御竹轩汤泉，周末清肺暖身游","description":"广州这几天灰霾霾的，找个山清水秀的地方放松下啦！这里竹林青青，温泉水雾腾腾，晚上躺在临河木屋小别墅，听溪水声潺潺，住在大自然的感觉爽得不要不要滴！泡过温泉顺道畅游下洞天仙境，坐着游船穿梭溶洞，漫步悬空玻璃栈道，惊险又刺激~","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/567a4bc945e38.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"598","title":"私密室内温泉pk寒潮大boss！","subTitle":"对澡堂式温泉say no!","description":"阴雨寒潮天气，室内温泉绝对是首选啦！\r\n温泉小院，1室1汤，私密性超高，很适合情侣~\r\n下面来看看超赞的私汤：\r\n望谷温泉，每间房都接驳了温泉水哦，一边泡汤，一边270°饱览流溪河美景；\r\n三英温泉，在苍郁山林间泡着私汤，古法中药泡汤养生又滋润，蒸走疲劳\u2026\u2026","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/56936f5561378.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"571","title":"周末1日游top榜【亲子篇】","subTitle":"一周走一个，带宝贝玩转你的城市！","description":"萌萌哒的泰迪熊，淘气的PORORO，500种30000多只极地海洋动物，各种主题游玩绝对轻松博熊娃一乐~~各种补习班兴趣班塞满孩子\u201c脑门\u201d，周末记得带孩子去放松下~","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/5683801a518bd.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"526","title":"温泉战斗机！广深出发2h内","subTitle":"汕尾水底山，广东最大的温泉池区","description":"何为温泉中的战斗机？\r\n1、距离近！广深出发2h内！\r\n2、环境美！峡谷林溪、瀑布河流环绕！\r\n3、汤池多！68个汤池，有特色喂奶鱼池、漂流河、河岸别墅私汤等！\r\n4、美食赞！潮汕小吃盛宴，牛肉丸、蚝烙、咸茶\u2026\u2026\r\n5、景点棒！周边有莲花山、红海湾等！","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/5671535cda503.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"542","title":"广东温泉奢壕榜TOP8","subTitle":"寒潮来啦！土豪都爱去哪泡？","description":"1、金叶子温泉\u2014高山林海上的巴厘岛\r\n2、都喜泰丽\u2014泰式风情spa\r\n3、三英温泉\u2014古法药浴是一绝\r\n4、香江健康山谷\u2014\u201c七星级\u201d欧陆风情\r\n5、美林湖温泉\u2014\u201c意大利山城\u201d\r\n6、龙门地派\u2014唐式华贵，禅乐仙境\r\n7、南昆山云顶温泉\u2014森林氧吧，\u201c云顶\u201d私汤\r\n8、御温泉\u2014汉唐风情，穿越小汤镇","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/567278a77a5b2.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"525","title":"温泉禅修，脚步跟上灵魂","subTitle":"古刹南华寺祈福，圣水曹溪泡温泉","description":"生活喧嚣繁杂让人心累，不如到韶关南华寺祈福禅修，品味洒脱自在的惬意！这里是禅宗六祖惠能宏扬\u201c南宗禅法\u201d的发源地，传说大师曾在曹溪沐浴净身，一夜之间顿悟佛理，曹溪水因此而成为千年圣水。礼佛祈福泡温泉，很适合带爸妈走起！","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/5671537755739.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"529","title":"充满幸运和挑战的Macau！","subTitle":"到澳门来碰碰运气！","description":"澳门素有\u201c东方蒙特卡罗\u201d之称，兴旺的博彩业，为其繁荣发展注入无限活力，也吸引众多富豪娱乐于此。当然它也因其众多的名胜古迹、宗教建筑，澳门可是有非常多的教堂，走进它，感受它的虔诚和静谧神圣。中西合璧的澳门饮食文化，挑战你的味蕾；223米的澳门旅游塔，极速挑战60秒，整个澳门就在你脚下。澳门不大，一两天就可以徒步走完，赶紧飞来吧！","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201601/5694af1c8777b.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"548","title":"元阳梯田，摄影季即将到！","subTitle":"中国第45处世界遗产,傻瓜机也能拍大片！","description":"最佳观赏节：1月\u20143月，春节前后最佳\r\n被摄影家们称为世界上最壮丽的田园风光的元阳梯田，每年1月-3月期间，层叠起伏的梯田灌满了水，波光粼粼，银光闪闪，森林茫茫，云海漫漫，总是烟雨迷蒙，好似一幅水墨山水画，傻瓜机也能拍出风光大片哦。春节前后则最佳，此时极易看到云海。一般在元宵前后，当地野樱花、野木棉花、野桃花和棠梨花开，满山的红、白色，漂亮极了。","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/5673c4b66c7ce.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""},{"themeId":"546","title":"梅里雪山，转山转水转佛塔","subTitle":"据说只有神的宠儿，才能见到日照金山！","description":"最佳季节：1-2月\r\n最佳观赏点：飞来寺、雾浓顶观景台\r\n联游推荐：雨崩、虎跳峡、 普达措国家公园\r\n藏民们捻着念珠，握着转经筒，绕山朝拜，只为了心中的\u201c雪山之神\u201d。这里终年云雾围绕，传说中能看到卡瓦格博全景的人，一年都有好运，而能看到日照金山的人，更是神的宠儿！","districtName":"广东","imageUrl":"http://cdn6.jinxidao.com/uploads/201512/56738117ed7b2.jpg","isAllowCoupon":0,"discountRate":0,"couponName":""}]
     */

    private ContentBean content;

    public static BottomImgBean objectFromData(String str) {

        return new Gson().fromJson(str, BottomImgBean.class);
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
        private int recordCount;
        /**
         * themeId : 613
         * title : 和风温泉小镇，暖暖好销魂
         * subTitle : 珠海御温泉，一天穿越盛唐&东瀛
         * description : 闲趣小汤镇，松石明月，柴门木屋，古风浓厚，御温泉既有盛唐的华贵style也有日式的清幽禅味。辽阔乡野、排排蕉林，踏着清脆的木屐，推开窗子，清鲜气息深入肺腑；夜晚星星点点，躺在华兴池来一个水中睡眠，或者体验下“通泡”的乐趣，六福汤、七颜汤、瀑布泉……
         * districtName : 广东
         * imageUrl : http://cdn6.jinxidao.com/uploads/201601/5698962b882c8.jpg
         * isAllowCoupon : 0
         * discountRate : 0
         * couponName :
         */

        private List<ThemeListBean> themeList;

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public int getRecordCount() {
            return recordCount;
        }

        public void setRecordCount(int recordCount) {
            this.recordCount = recordCount;
        }

        public List<ThemeListBean> getThemeList() {
            return themeList;
        }

        public void setThemeList(List<ThemeListBean> themeList) {
            this.themeList = themeList;
        }

        public static class ThemeListBean {
            private String themeId;
            private String title;
            private String subTitle;
            private String description;
            private String districtName;
            private String imageUrl;
            private int isAllowCoupon;
            private int discountRate;
            private String couponName;

            public static ThemeListBean objectFromData(String str) {

                return new Gson().fromJson(str, ThemeListBean.class);
            }

            public String getThemeId() {
                return themeId;
            }

            public void setThemeId(String themeId) {
                this.themeId = themeId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDistrictName() {
                return districtName;
            }

            public void setDistrictName(String districtName) {
                this.districtName = districtName;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getIsAllowCoupon() {
                return isAllowCoupon;
            }

            public void setIsAllowCoupon(int isAllowCoupon) {
                this.isAllowCoupon = isAllowCoupon;
            }

            public int getDiscountRate() {
                return discountRate;
            }

            public void setDiscountRate(int discountRate) {
                this.discountRate = discountRate;
            }

            public String getCouponName() {
                return couponName;
            }

            public void setCouponName(String couponName) {
                this.couponName = couponName;
            }
        }
    }
}
