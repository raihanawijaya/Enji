package msd.mobile.enji.services;

public class RetrofitServices {
    public static DataAPIInterface sendDataRequest(){
        return APIClient.getAPIClient().create(DataAPIInterface.class);
    }
}
