package demo.wuchunmei.com.code;

import java.util.List;

/**
 * 热门推荐返回的数据
 *
 * @author chenyacheng
 * @date 2019/03/20
 */
public class HotRecommendationResult {

    /**
     * pageCount : 2
     * lastPage : false
     * prePage : 1
     * pageIndexKey : pageWrapper.pageIndex
     * maxPageSize : 5000
     * maxRowCount : 0
     * jsonString : null
     * pageIndexKeyStr : pageWrapper.pageIndexStr
     * pageSize : 3
     * paramEncoding : utf-8
     * list : [{"returnCode":null,"returnMessage":null,"dynFields":{"hotelDistId":"82bacd16504211e99af600e0706116b0","hotelLivingRoom":2,"hotelStatus":"3","hotelId":2813,"hotelCreateDate":1553498245837,"hotelSuitableNumber":5,"hotelLabels":"拎包入住,可做饭,有车位,有电梯,自助入住","hotelName":"金盛公寓","hotelBedroom":3,"hotelToilet":2},"id":0,"productId":null,"grpId":"22","title":null,"content":null,"image":"hotel/2813/manage/cover/cover.jpg","clickUrl":null,"beginDate":null,"endDate":null,"price":100.65,"createBy":null,"createDate":null,"verifier":0,"status":null,"orderId":0,"remark":null,"shareType":"7","origPrice":0,"integral":0,"fkey":"2813","json":"{\"FKey\":\"2813\",\"beginDate\":null,\"clickUrl\":null,\"content\":null,\"createBy\":null,\"createDate\":null,\"endDate\":null,\"grpId\":\"22\",\"id\":0,\"image\":\"hotel/2813/manage/cover/cover.jpg\",\"integral\":0,\"orderId\":0,\"origPrice\":0.0,\"price\":100.65,\"productId\":null,\"remark\":null,\"returnCode\":null,\"returnMessage\":null,\"shareType\":\"7\",\"status\":null,\"title\":null,\"verifier\":0}"},{"returnCode":null,"returnMessage":null,"dynFields":{"hotelDistId":"20062d43504311e99af600e0706116b0","hotelLivingRoom":2,"hotelStatus":"3","hotelId":2808,"hotelCreateDate":1553222799826,"hotelSuitableNumber":2,"hotelLabels":"","hotelName":"凤凰岛酒店","hotelBedroom":2,"hotelToilet":2},"id":0,"productId":null,"grpId":"22","title":null,"content":null,"image":"hotel/2808/manage/cover/cover.jpg","clickUrl":null,"beginDate":null,"endDate":null,"price":100,"createBy":null,"createDate":null,"verifier":0,"status":null,"orderId":0,"remark":null,"shareType":"7","origPrice":0,"integral":0,"fkey":"2808","json":"{\"FKey\":\"2808\",\"beginDate\":null,\"clickUrl\":null,\"content\":null,\"createBy\":null,\"createDate\":null,\"endDate\":null,\"grpId\":\"22\",\"id\":0,\"image\":\"hotel/2808/manage/cover/cover.jpg\",\"integral\":0,\"orderId\":0,\"origPrice\":0.0,\"price\":100.0,\"productId\":null,\"remark\":null,\"returnCode\":null,\"returnMessage\":null,\"shareType\":\"7\",\"status\":null,\"title\":null,\"verifier\":0}"},{"returnCode":null,"returnMessage":null,"dynFields":{"hotelDistId":"20062d43504311e99af600e0706116b0","hotelLivingRoom":2,"hotelStatus":"3","hotelId":2806,"hotelCreateDate":1553219889608,"hotelSuitableNumber":5,"hotelLabels":"","hotelName":"红城湖公寓","hotelBedroom":2,"hotelToilet":2},"id":0,"productId":null,"grpId":"22","title":null,"content":null,"image":"hotel/2806/manage/cover/cover.jpg","clickUrl":null,"beginDate":null,"endDate":null,"price":0.02,"createBy":null,"createDate":null,"verifier":0,"status":null,"orderId":0,"remark":null,"shareType":"7","origPrice":0,"integral":0,"fkey":"2806","json":"{\"FKey\":\"2806\",\"beginDate\":null,\"clickUrl\":null,\"content\":null,\"createBy\":null,\"createDate\":null,\"endDate\":null,\"grpId\":\"22\",\"id\":0,\"image\":\"hotel/2806/manage/cover/cover.jpg\",\"integral\":0,\"orderId\":0,\"origPrice\":0.0,\"price\":0.02,\"productId\":null,\"remark\":null,\"returnCode\":null,\"returnMessage\":null,\"shareType\":\"7\",\"status\":null,\"title\":null,\"verifier\":0}"}]
     * params :
     * rowOffset : 0
     * nextpage : 2
     * s : {"bedroom":null,"lowPrice":null,"highPrice":null,"checkInDate":null,"leavingDate":null,"qtime":0,"typeKey":null,"kind":null,"id":"22","identify":null,"itinNo":null,"userId":0,"roleId":0,"beginDate":null,"endDate":null,"beginTime":null,"endTime":null,"strBeginTime":null,"strEndTime":null,"beginCode":null,"endCode":null,"star":null,"type":null,"key":"1","priceTop":null,"priceEnd":null,"name":null,"mobile":null,"multi":0,"count":0,"day":0,"feature":-1,"orderK":null,"orderV":null,"status":null,"address":null,"phone":null,"submitSource":null,"param1":"7","param2":null,"param3":null,"param4":null,"param5":null,"param6":null,"param7":null,"param8":null,"param9":null,"param10":null,"source":null,"expireDate":null,"locationSwitch":"off","point":null,"lat":0,"lng":0,"userlat":0,"userlng":0,"latSize":0.00984,"lngSize":0.00895,"includeSelf":404,"model":{"hotelStatus":"3"}}
     * firstPage : true
     * pageIndex : 1
     * pageIndexStr : null
     * rowCount : 6
     */

    private String pageCount;
    private boolean lastPage;
    private String prePage;
    private String pageIndexKey;
    private String maxPageSize;
    private int maxRowCount;
    private Object jsonString;
    private String pageIndexKeyStr;
    private String pageSize;
    private String paramEncoding;
    private String params;
    private String rowOffset;
    private String nextpage;
    private SBean s;
    private boolean firstPage;
    private String pageIndex;
    private String pageIndexStr;
    private int rowCount;
    private List<ListBean> list;

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public String getPrePage() {
        return prePage;
    }

    public void setPrePage(String prePage) {
        this.prePage = prePage;
    }

    public String getPageIndexKey() {
        return pageIndexKey;
    }

    public void setPageIndexKey(String pageIndexKey) {
        this.pageIndexKey = pageIndexKey;
    }

    public String getMaxPageSize() {
        return maxPageSize;
    }

    public void setMaxPageSize(String maxPageSize) {
        this.maxPageSize = maxPageSize;
    }

    public int getMaxRowCount() {
        return maxRowCount;
    }

    public void setMaxRowCount(int maxRowCount) {
        this.maxRowCount = maxRowCount;
    }

    public Object getJsonString() {
        return jsonString;
    }

    public void setJsonString(Object jsonString) {
        this.jsonString = jsonString;
    }

    public String getPageIndexKeyStr() {
        return pageIndexKeyStr;
    }

    public void setPageIndexKeyStr(String pageIndexKeyStr) {
        this.pageIndexKeyStr = pageIndexKeyStr;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getParamEncoding() {
        return paramEncoding;
    }

    public void setParamEncoding(String paramEncoding) {
        this.paramEncoding = paramEncoding;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getRowOffset() {
        return rowOffset;
    }

    public void setRowOffset(String rowOffset) {
        this.rowOffset = rowOffset;
    }

    public String getNextpage() {
        return nextpage;
    }

    public void setNextpage(String nextpage) {
        this.nextpage = nextpage;
    }

    public SBean getS() {
        return s;
    }

    public void setS(SBean s) {
        this.s = s;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getPageIndexStr() {
        return pageIndexStr;
    }

    public void setPageIndexStr(String pageIndexStr) {
        this.pageIndexStr = pageIndexStr;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class SBean {
        /**
         * bedroom : null
         * lowPrice : null
         * highPrice : null
         * checkInDate : null
         * leavingDate : null
         * qtime : 0
         * typeKey : null
         * kind : null
         * id : 22
         * identify : null
         * itinNo : null
         * userId : 0
         * roleId : 0
         * beginDate : null
         * endDate : null
         * beginTime : null
         * endTime : null
         * strBeginTime : null
         * strEndTime : null
         * beginCode : null
         * endCode : null
         * star : null
         * type : null
         * key : 1
         * priceTop : null
         * priceEnd : null
         * name : null
         * mobile : null
         * multi : 0
         * count : 0
         * day : 0
         * feature : -1
         * orderK : null
         * orderV : null
         * status : null
         * address : null
         * phone : null
         * submitSource : null
         * param1 : 7
         * param2 : null
         * param3 : null
         * param4 : null
         * param5 : null
         * param6 : null
         * param7 : null
         * param8 : null
         * param9 : null
         * param10 : null
         * source : null
         * expireDate : null
         * locationSwitch : off
         * point : null
         * lat : 0
         * lng : 0
         * userlat : 0
         * userlng : 0
         * latSize : 0.00984
         * lngSize : 0.00895
         * includeSelf : 404
         * model : {"hotelStatus":"3"}
         */

        private Object bedroom;
        private Object lowPrice;
        private Object highPrice;
        private Object checkInDate;
        private Object leavingDate;
        private int qtime;
        private Object typeKey;
        private Object kind;
        private String id;
        private Object identify;
        private Object itinNo;
        private int userId;
        private int roleId;
        private Object beginDate;
        private Object endDate;
        private Object beginTime;
        private Object endTime;
        private Object strBeginTime;
        private Object strEndTime;
        private Object beginCode;
        private Object endCode;
        private Object star;
        private Object type;
        private String key;
        private Object priceTop;
        private Object priceEnd;
        private Object name;
        private Object mobile;
        private int multi;
        private int count;
        private int day;
        private int feature;
        private Object orderK;
        private Object orderV;
        private Object status;
        private Object address;
        private Object phone;
        private Object submitSource;
        private String param1;
        private Object param2;
        private Object param3;
        private Object param4;
        private Object param5;
        private Object param6;
        private Object param7;
        private Object param8;
        private Object param9;
        private Object param10;
        private Object source;
        private Object expireDate;
        private String locationSwitch;
        private Object point;
        private int lat;
        private int lng;
        private int userlat;
        private int userlng;
        private double latSize;
        private double lngSize;
        private int includeSelf;
        private ModelBean model;

        public Object getBedroom() {
            return bedroom;
        }

        public void setBedroom(Object bedroom) {
            this.bedroom = bedroom;
        }

        public Object getLowPrice() {
            return lowPrice;
        }

        public void setLowPrice(Object lowPrice) {
            this.lowPrice = lowPrice;
        }

        public Object getHighPrice() {
            return highPrice;
        }

        public void setHighPrice(Object highPrice) {
            this.highPrice = highPrice;
        }

        public Object getCheckInDate() {
            return checkInDate;
        }

        public void setCheckInDate(Object checkInDate) {
            this.checkInDate = checkInDate;
        }

        public Object getLeavingDate() {
            return leavingDate;
        }

        public void setLeavingDate(Object leavingDate) {
            this.leavingDate = leavingDate;
        }

        public int getQtime() {
            return qtime;
        }

        public void setQtime(int qtime) {
            this.qtime = qtime;
        }

        public Object getTypeKey() {
            return typeKey;
        }

        public void setTypeKey(Object typeKey) {
            this.typeKey = typeKey;
        }

        public Object getKind() {
            return kind;
        }

        public void setKind(Object kind) {
            this.kind = kind;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getIdentify() {
            return identify;
        }

        public void setIdentify(Object identify) {
            this.identify = identify;
        }

        public Object getItinNo() {
            return itinNo;
        }

        public void setItinNo(Object itinNo) {
            this.itinNo = itinNo;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public Object getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(Object beginDate) {
            this.beginDate = beginDate;
        }

        public Object getEndDate() {
            return endDate;
        }

        public void setEndDate(Object endDate) {
            this.endDate = endDate;
        }

        public Object getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(Object beginTime) {
            this.beginTime = beginTime;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public Object getStrBeginTime() {
            return strBeginTime;
        }

        public void setStrBeginTime(Object strBeginTime) {
            this.strBeginTime = strBeginTime;
        }

        public Object getStrEndTime() {
            return strEndTime;
        }

        public void setStrEndTime(Object strEndTime) {
            this.strEndTime = strEndTime;
        }

        public Object getBeginCode() {
            return beginCode;
        }

        public void setBeginCode(Object beginCode) {
            this.beginCode = beginCode;
        }

        public Object getEndCode() {
            return endCode;
        }

        public void setEndCode(Object endCode) {
            this.endCode = endCode;
        }

        public Object getStar() {
            return star;
        }

        public void setStar(Object star) {
            this.star = star;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getPriceTop() {
            return priceTop;
        }

        public void setPriceTop(Object priceTop) {
            this.priceTop = priceTop;
        }

        public Object getPriceEnd() {
            return priceEnd;
        }

        public void setPriceEnd(Object priceEnd) {
            this.priceEnd = priceEnd;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public int getMulti() {
            return multi;
        }

        public void setMulti(int multi) {
            this.multi = multi;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getFeature() {
            return feature;
        }

        public void setFeature(int feature) {
            this.feature = feature;
        }

        public Object getOrderK() {
            return orderK;
        }

        public void setOrderK(Object orderK) {
            this.orderK = orderK;
        }

        public Object getOrderV() {
            return orderV;
        }

        public void setOrderV(Object orderV) {
            this.orderV = orderV;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public Object getSubmitSource() {
            return submitSource;
        }

        public void setSubmitSource(Object submitSource) {
            this.submitSource = submitSource;
        }

        public String getParam1() {
            return param1;
        }

        public void setParam1(String param1) {
            this.param1 = param1;
        }

        public Object getParam2() {
            return param2;
        }

        public void setParam2(Object param2) {
            this.param2 = param2;
        }

        public Object getParam3() {
            return param3;
        }

        public void setParam3(Object param3) {
            this.param3 = param3;
        }

        public Object getParam4() {
            return param4;
        }

        public void setParam4(Object param4) {
            this.param4 = param4;
        }

        public Object getParam5() {
            return param5;
        }

        public void setParam5(Object param5) {
            this.param5 = param5;
        }

        public Object getParam6() {
            return param6;
        }

        public void setParam6(Object param6) {
            this.param6 = param6;
        }

        public Object getParam7() {
            return param7;
        }

        public void setParam7(Object param7) {
            this.param7 = param7;
        }

        public Object getParam8() {
            return param8;
        }

        public void setParam8(Object param8) {
            this.param8 = param8;
        }

        public Object getParam9() {
            return param9;
        }

        public void setParam9(Object param9) {
            this.param9 = param9;
        }

        public Object getParam10() {
            return param10;
        }

        public void setParam10(Object param10) {
            this.param10 = param10;
        }

        public Object getSource() {
            return source;
        }

        public void setSource(Object source) {
            this.source = source;
        }

        public Object getExpireDate() {
            return expireDate;
        }

        public void setExpireDate(Object expireDate) {
            this.expireDate = expireDate;
        }

        public String getLocationSwitch() {
            return locationSwitch;
        }

        public void setLocationSwitch(String locationSwitch) {
            this.locationSwitch = locationSwitch;
        }

        public Object getPoint() {
            return point;
        }

        public void setPoint(Object point) {
            this.point = point;
        }

        public int getLat() {
            return lat;
        }

        public void setLat(int lat) {
            this.lat = lat;
        }

        public int getLng() {
            return lng;
        }

        public void setLng(int lng) {
            this.lng = lng;
        }

        public int getUserlat() {
            return userlat;
        }

        public void setUserlat(int userlat) {
            this.userlat = userlat;
        }

        public int getUserlng() {
            return userlng;
        }

        public void setUserlng(int userlng) {
            this.userlng = userlng;
        }

        public double getLatSize() {
            return latSize;
        }

        public void setLatSize(double latSize) {
            this.latSize = latSize;
        }

        public double getLngSize() {
            return lngSize;
        }

        public void setLngSize(double lngSize) {
            this.lngSize = lngSize;
        }

        public int getIncludeSelf() {
            return includeSelf;
        }

        public void setIncludeSelf(int includeSelf) {
            this.includeSelf = includeSelf;
        }

        public ModelBean getModel() {
            return model;
        }

        public void setModel(ModelBean model) {
            this.model = model;
        }

        public static class ModelBean {
            /**
             * hotelStatus : 3
             */

            private String hotelStatus;

            public String getHotelStatus() {
                return hotelStatus;
            }

            public void setHotelStatus(String hotelStatus) {
                this.hotelStatus = hotelStatus;
            }
        }
    }

    public static class ListBean {
        /**
         * returnCode : null
         * returnMessage : null
         * dynFields : {"hotelDistId":"82bacd16504211e99af600e0706116b0","hotelLivingRoom":2,"hotelStatus":"3","hotelId":2813,"hotelCreateDate":1553498245837,"hotelSuitableNumber":5,"hotelLabels":"拎包入住,可做饭,有车位,有电梯,自助入住","hotelName":"金盛公寓","hotelBedroom":3,"hotelToilet":2}
         * id : 0
         * productId : null
         * grpId : 22
         * title : null
         * content : null
         * image : hotel/2813/manage/cover/cover.jpg
         * clickUrl : null
         * beginDate : null
         * endDate : null
         * price : 100.65
         * createBy : null
         * createDate : null
         * verifier : 0
         * status : null
         * orderId : 0
         * remark : null
         * shareType : 7
         * origPrice : 0
         * integral : 0
         * fkey : 2813
         * json : {"FKey":"2813","beginDate":null,"clickUrl":null,"content":null,"createBy":null,"createDate":null,"endDate":null,"grpId":"22","id":0,"image":"hotel/2813/manage/cover/cover.jpg","integral":0,"orderId":0,"origPrice":0.0,"price":100.65,"productId":null,"remark":null,"returnCode":null,"returnMessage":null,"shareType":"7","status":null,"title":null,"verifier":0}
         */

        private Object returnCode;
        private Object returnMessage;
        private DynFieldsBean dynFields;
        private int id;
        private Object productId;
        private String grpId;
        private Object title;
        private Object content;
        private String image;
        private Object clickUrl;
        private Object beginDate;
        private Object endDate;
        private double price;
        private Object createBy;
        private Object createDate;
        private int verifier;
        private Object status;
        private int orderId;
        private Object remark;
        private String shareType;
        private int origPrice;
        private int integral;
        private String fkey;
        private String json;

        public Object getReturnCode() {
            return returnCode;
        }

        public void setReturnCode(Object returnCode) {
            this.returnCode = returnCode;
        }

        public Object getReturnMessage() {
            return returnMessage;
        }

        public void setReturnMessage(Object returnMessage) {
            this.returnMessage = returnMessage;
        }

        public DynFieldsBean getDynFields() {
            return dynFields;
        }

        public void setDynFields(DynFieldsBean dynFields) {
            this.dynFields = dynFields;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getProductId() {
            return productId;
        }

        public void setProductId(Object productId) {
            this.productId = productId;
        }

        public String getGrpId() {
            return grpId;
        }

        public void setGrpId(String grpId) {
            this.grpId = grpId;
        }

        public Object getTitle() {
            return title;
        }

        public void setTitle(Object title) {
            this.title = title;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public String getImage() {
            return image == null ? "" : image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Object getClickUrl() {
            return clickUrl;
        }

        public void setClickUrl(Object clickUrl) {
            this.clickUrl = clickUrl;
        }

        public Object getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(Object beginDate) {
            this.beginDate = beginDate;
        }

        public Object getEndDate() {
            return endDate;
        }

        public void setEndDate(Object endDate) {
            this.endDate = endDate;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public Object getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Object createDate) {
            this.createDate = createDate;
        }

        public int getVerifier() {
            return verifier;
        }

        public void setVerifier(int verifier) {
            this.verifier = verifier;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public String getShareType() {
            return shareType;
        }

        public void setShareType(String shareType) {
            this.shareType = shareType;
        }

        public int getOrigPrice() {
            return origPrice;
        }

        public void setOrigPrice(int origPrice) {
            this.origPrice = origPrice;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getFkey() {
            return fkey == null ? "" : fkey;
        }

        public void setFkey(String fkey) {
            this.fkey = fkey;
        }

        public String getJson() {
            return json;
        }

        public void setJson(String json) {
            this.json = json;
        }

        public static class DynFieldsBean {
            /**
             * hotelDistId : 82bacd16504211e99af600e0706116b0
             * hotelLivingRoom : 2
             * hotelStatus : 3
             * hotelId : 2813
             * hotelCreateDate : 1553498245837
             * hotelSuitableNumber : 5
             * hotelLabels : 拎包入住,可做饭,有车位,有电梯,自助入住
             * hotelName : 金盛公寓
             * hotelBedroom : 3
             * hotelToilet : 2
             */

            private String hotelDistId;
            private int hotelLivingRoom;
            private String hotelStatus;
            private int hotelId;
            private long hotelCreateDate;
            private int hotelSuitableNumber;
            private String hotelLabels;
            private String hotelName;
            private int hotelBedroom;
            private int hotelToilet;

            public String getHotelDistId() {
                return hotelDistId;
            }

            public void setHotelDistId(String hotelDistId) {
                this.hotelDistId = hotelDistId;
            }

            public int getHotelLivingRoom() {
                return hotelLivingRoom;
            }

            public void setHotelLivingRoom(int hotelLivingRoom) {
                this.hotelLivingRoom = hotelLivingRoom;
            }

            public String getHotelStatus() {
                return hotelStatus;
            }

            public void setHotelStatus(String hotelStatus) {
                this.hotelStatus = hotelStatus;
            }

            public int getHotelId() {
                return hotelId;
            }

            public void setHotelId(int hotelId) {
                this.hotelId = hotelId;
            }

            public long getHotelCreateDate() {
                return hotelCreateDate;
            }

            public void setHotelCreateDate(long hotelCreateDate) {
                this.hotelCreateDate = hotelCreateDate;
            }

            public int getHotelSuitableNumber() {
                return hotelSuitableNumber;
            }

            public void setHotelSuitableNumber(int hotelSuitableNumber) {
                this.hotelSuitableNumber = hotelSuitableNumber;
            }

            public String getHotelLabels() {
                return hotelLabels == null ? "" : hotelLabels;
            }

            public void setHotelLabels(String hotelLabels) {
                this.hotelLabels = hotelLabels;
            }

            public String getHotelName() {
                return hotelName == null ? "" : hotelName;
            }

            public void setHotelName(String hotelName) {
                this.hotelName = hotelName;
            }

            public int getHotelBedroom() {
                return hotelBedroom;
            }

            public void setHotelBedroom(int hotelBedroom) {
                this.hotelBedroom = hotelBedroom;
            }

            public int getHotelToilet() {
                return hotelToilet;
            }

            public void setHotelToilet(int hotelToilet) {
                this.hotelToilet = hotelToilet;
            }
        }
    }
}
