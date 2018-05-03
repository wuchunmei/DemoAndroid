package demo.wuchunmei.com.net;

/**
 * 服务端响应数据
 */
public final class ResponseResultData<T> {

    // code 说明：
    // 200 返回正常
    // 500 执行失败

    /**
     * 接口请求成功
     */
    public static final int RESPONCE_CODE_SUCCESS = 200;
    /**
     * 失败
     */
    public static final int RESPONCE_CODE_FAILED = 500;

    public static final int RESPONCE_ERROR_CONNECTERROR = 10000;
    public static final int RESPONCE_ERROR_TIMEOUT = 10001;
    public static final int RESPONCE_ERROR_DATAPARSEERROR = 10002;
    public static final int RESPONCE_ERROR_DATANOENOUGH = 10003;
    public static final int RESPONCE_ERROR_SERVERERROR = 10004;
    public static final int RESPONCE_ERROR_NOCONNECTION = 10005;
    public static final int RESPONCE_ERROR_UPLOADFILEFAILED = 10006;
    public static final int RESPONCE_ERROR_PARAMERROR = 10007;

    public static final ResponseResultData responseSuccess = new ResponseResultData();

    public static final ResponseResultData responseFailed = new ResponseResultData(RESPONCE_CODE_FAILED);

    public static ResponseResultData responseConnectError = new ResponseResultData(
            ResponseResultData.RESPONCE_ERROR_CONNECTERROR);
    public static ResponseResultData responseDataNoEnough = new ResponseResultData(
            ResponseResultData.RESPONCE_ERROR_DATANOENOUGH);
    public static ResponseResultData responseDataParseError = new ResponseResultData(
            ResponseResultData.RESPONCE_ERROR_DATAPARSEERROR);
    public static ResponseResultData responseNoConnection = new ResponseResultData(
            ResponseResultData.RESPONCE_ERROR_NOCONNECTION);
    public static ResponseResultData responseParamError = new ResponseResultData(
            ResponseResultData.RESPONCE_ERROR_PARAMERROR);

    public final int code;
    public String msg;
    public String dataStr;
    public T data;

    public boolean success(){
        return code == RESPONCE_CODE_SUCCESS;
    }

    public ResponseResultData(int code) {
        this.code = code;
    }

    public ResponseResultData() {
        this.code = RESPONCE_CODE_SUCCESS;
    }

    public T getData(){
        return data;
    }

    @Override
    public String toString() {
        return ";code = " + code +
                ";msg = " + msg +
                ";data = " + dataStr;
    }


}
