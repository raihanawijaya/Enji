package msd.mobile.enji.services;

import msd.mobile.enji.model.BaseModel;
import msd.mobile.enji.model.DailyMTDDiscCodeTransactionResponse;
import msd.mobile.enji.model.DailyMTDNotCodeTransactionResponse;
import msd.mobile.enji.model.DailyMTDStoreCodeTransactionResponse;
import msd.mobile.enji.model.DailyTransactionStore;
import msd.mobile.enji.model.DataMtdTransactionTotalResponse;
import msd.mobile.enji.model.DataTransactionDiscResponse;
import msd.mobile.enji.model.DataTransactionResponse;
import msd.mobile.enji.model.DataTransactionTotalResponse;
import msd.mobile.enji.model.LoginResponses;
import msd.mobile.enji.model.MTDPlanChiefCodeTransactionResponse;
import msd.mobile.enji.model.PROC_DAILY_SALES_STORE_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_DAILY_SALES_PRODUCT_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_DAILY_SALES_ARTICLE_CODE_RESPONSE;

import msd.mobile.enji.model.PROC_MTD_ABSENSI_STORE_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_DELIVERY_CHIEF_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_DELIVERY_DAILY_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_OPNAME_STORE_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_SALES_CTGR_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_SALES_DAILY_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_SALES_DAILY_LY_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_SALES_DEPT_STORE_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_SALES_DISC_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_SALES_LIVE_REPORT_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_SALES_MODEL_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_SALES_ARTICLE_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_SALES_ANNUAL_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_SALES_MODEL_CTGR_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_SALES_STORE_BEST_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_SALES_STORE_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_SALES_STORE_WORST_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_STOCK_STORE_CODE_RESPONSE;
import msd.mobile.enji.model.PROC_MTD_STORE_NOT_SEND_RESPONSE;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

//----------- Import Model For Data Transaction Result Responce

public interface DataAPIInterface {

    @FormUrlEncoded
    @POST("loginUser.php")
    Call<LoginResponses> loginUser(@Field("USER_CODE") String user_code, @Field("USER_PASS") String user_pass);


    @FormUrlEncoded
    @POST("getTodayMtdSalesTotal.php")
    Call<DataTransactionResponse> getTodayMtdSalesTotal(@Field("TRX_DATE") String trxDate);


    @FormUrlEncoded
    @POST("getViewTransaction.php")
    Call<DataTransactionResponse> getDataTransaction(@Field("STORE_CODE") String storecode,
                                                     @Field("TRX_DATE") String trxDate,
                                                     @Field("Y_ID") String y_id,
                                                     @Field("M_ID") String m_id);

    @FormUrlEncoded
    @POST("getViewTransactionDisc.php")
    Call<DataTransactionDiscResponse> getDataTransactionDisc(@Field("STORE_CODE") String storecode,
                                                             @Field("TRX_DATE") String trxDate,
                                                             @Field("Y_ID") String y_id,
                                                             @Field("M_ID") String m_id);

    @FormUrlEncoded
    @POST("getViewTransactionChief.php")
    Call<DataTransactionResponse> getDataTransactionChief(@Field("STORE_CODE") String storecode,
                                                          @Field("TRX_DATE") String trxDate,
                                                          @Field("Y_ID") String y_id,
                                                          @Field("M_ID") String m_id);
    @FormUrlEncoded
    @POST("getViewTransactionTotal.php")
    Call<DataTransactionTotalResponse> getDataTransactionTotal(@Field("STORE_CODE") String storecode,
                                                               @Field("TRX_DATE") String trxDate,
                                                               @Field("Y_ID") String y_id,
                                                               @Field("M_ID") String m_id);
    @FormUrlEncoded
    @POST("getViewMtdTransactionTotal.php")
    Call<DataMtdTransactionTotalResponse> getMtdTransactionTotal(@Field("STORE_CODE") String storecode,
                                                                 @Field("TRX_DATE") String trx_date,
                                                                 @Field("Y_ID") String y_id,
                                                                 @Field("M_ID") String m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_SALES_PLAN_CHIEF.php")
    Call<MTDPlanChiefCodeTransactionResponse> getMTDTrxChief(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_SALES_DISC_CODE.php")
    Call<PROC_MTD_SALES_DISC_CODE_RESPONSE> GET_MTD_SALES_DISC_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_SALES_DEPT_STORE_CODE.php")
    Call<PROC_MTD_SALES_DEPT_STORE_CODE_RESPONSE> GET_MTD_SALES_DEPT_STORE_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_DAILY_SALES_STORE_CODE.php")
    Call<PROC_DAILY_SALES_STORE_CODE_RESPONSE> GET_DAILY_SALES_STORE_CODE(
            @Field("P_TRX_DATE") String date);

    @FormUrlEncoded
    @POST("PROC_DAILY_SALES_PRODUCT_CODE.php")
    Call<PROC_DAILY_SALES_PRODUCT_CODE_RESPONSE> GET_DAILY_SALES_PRODUCT_CODE(
            @Field("P_TRX_DATE") String date);

    @FormUrlEncoded
    @POST("PROC_DAILY_SALES_ARTICLE_CODE.php")
    Call<PROC_DAILY_SALES_ARTICLE_CODE_RESPONSE> GET_DAILY_SALES_ARTICLE_CODE(
            @Field("P_TRX_DATE") String date);

    @FormUrlEncoded
    @POST("PROC_MTD_SALES_CTGR_CODE.php")
    Call<PROC_MTD_SALES_CTGR_CODE_RESPONSE> GET_MTD_SALES_CTGR_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_SALES_MODEL_CODE.php")
    Call<PROC_MTD_SALES_MODEL_CODE_RESPONSE> GET_MTD_SALES_MODEL_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_SALES_ARTICLE_CODE.php")
    Call<PROC_MTD_SALES_ARTICLE_CODE_RESPONSE> GET_MTD_SALES_ARTICLE_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_SALES_ANNUAL_CODE.php")
    Call<PROC_MTD_SALES_ANNUAL_CODE_RESPONSE> GET_MTD_SALES_ANNUAL_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);


    @FormUrlEncoded
    @POST("PROC_MTD_SALES_MODEL_CTGR_CODE.php")
    Call<PROC_MTD_SALES_MODEL_CTGR_CODE_RESPONSE> GET_MTD_SALES_MODEL_CTGR_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_DELIVERY_CHIEF_CODE.php")
    Call<PROC_MTD_DELIVERY_CHIEF_CODE_RESPONSE> GET_MTD_DELIVERY_CHIEF_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_DELIVERY_DAILY_CODE.php")
    Call<PROC_MTD_DELIVERY_DAILY_CODE_RESPONSE> GET_MTD_DELIVERY_DAILY_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_SALES_DAILY_CODE.php")
    Call<PROC_MTD_SALES_DAILY_CODE_RESPONSE> GET_MTD_SALES_DAILY_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_SALES_LIVE_REPORT.php")
    Call<PROC_MTD_SALES_LIVE_REPORT_RESPONSE> GET_MTD_SALES_LIVE_REPORT(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);


    @FormUrlEncoded
    @POST("PROC_MTD_SALES_DAILY_LY_CODE.php")
    Call<PROC_MTD_SALES_DAILY_LY_CODE_RESPONSE> GET_MTD_SALES_DAILY_LY_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_SALES_STORE_CODE.php")
    Call<PROC_MTD_SALES_STORE_CODE_RESPONSE> GET_MTD_SALES_STORE_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);


    @FormUrlEncoded
    @POST("PROC_MTD_STOCK_STORE_CODE.php")
    Call<PROC_MTD_STOCK_STORE_CODE_RESPONSE> GET_MTD_STOCK_STORE_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);


    @FormUrlEncoded
    @POST("PROC_MTD_OPNAME_STORE_CODE.php")
    Call<PROC_MTD_OPNAME_STORE_CODE_RESPONSE> GET_MTD_OPNAME_STORE_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_ABSENSI_STORE_CODE.php")
    Call<PROC_MTD_ABSENSI_STORE_CODE_RESPONSE> GET_MTD_ABSENSI_STORE_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);



    @FormUrlEncoded
    @POST("PROC_MTD_SALES_STORE_BEST_CODE.php")
    Call<PROC_MTD_SALES_STORE_BEST_CODE_RESPONSE> GET_MTD_SALES_STORE_BEST_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_SALES_STORE_WORST_CODE.php")
    Call<PROC_MTD_SALES_STORE_WORST_CODE_RESPONSE> GET_MTD_SALES_STORE_WORST_CODE(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("PROC_MTD_STORE_NOT_SEND.php")
    Call<PROC_MTD_STORE_NOT_SEND_RESPONSE> GET_MTD_STORE_NOT_SEND(
            @Field("P_YEAR_CODE") Integer p_y_id, @Field("P_MONTH_CODE") Integer p_m_id);

    @FormUrlEncoded
    @POST("getViewDailyMTDDiscCodeTransaction.php")
    Call<DailyMTDDiscCodeTransactionResponse> getDailyTrxDisc(@Field("TRX_DATE") String trx_date);

    @FormUrlEncoded
    @POST("getViewDailyMTDStoreCodeTransaction.php")
    Call<DailyMTDStoreCodeTransactionResponse> getDailyTrxStore(@Field("STORE_CODE") String storeCode, @Field("TRX_DATE") String trx_date);

    @FormUrlEncoded
    @POST("getViewDailyMTDNotCodeTransaction.php")
    Call<DailyMTDNotCodeTransactionResponse> getDailyTrxNot(@Field("STORE_CODE") String storeCode, @Field("TRX_DATE") String trx_date);


    @FormUrlEncoded
    @POST("getViewDailyTransactionStoreTotal.php")
    Call<BaseModel<DailyTransactionStore>> getViewDailyTransactionStoreTotal(
            @Field("P_STR_CODE") String P_STR_CODE,
            @Field("P_Y_CODE") String P_Y_CODE,
            @Field("P_M_CODE") String P_M_CODE
    );


}
