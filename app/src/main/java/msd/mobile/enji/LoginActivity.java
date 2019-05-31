package msd.mobile.enji;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import msd.mobile.enji.model.LoginResponses;
import msd.mobile.enji.model.StoreModel;
import msd.mobile.enji.services.RetrofitServices;
import msd.mobile.enji.utils.SharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText etUser_Code, etUser_Pass;
    private Button btnMasuk;

    private SharedPreference sharedPreference;

    private ProgressDialog loginLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);
       //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
       // input.setRawInputType(Configuration.KEYBOARD_12KEY);
        loginLoading = new ProgressDialog(this);
        loginLoading.setMessage("Log In . . .");
        loginLoading.setCancelable(false);

        sharedPreference = new SharedPreference(this);

        if (sharedPreference.isLoggedIn()) {
            //startActivity(new Intent(this, MainActivity.class));
            //finish();
        }

        etUser_Code = findViewById(R.id.et_user_code);
        etUser_Pass = findViewById(R.id.et_user_pass);
        btnMasuk = findViewById(R.id.btn_masuk);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_code = etUser_Code.getText().toString();
                String user_pass = etUser_Pass.getText().toString();

                if (isInputValid(user_code, user_pass)) {
                    loginUser(user_code, user_pass);
                }
            }
        });
    }

    private boolean isInputValid(String usercode, String user_pass) {
        if (TextUtils.isEmpty(usercode) || TextUtils.isEmpty(user_pass)) {
            if (TextUtils.isEmpty(usercode)) {
                etUser_Code.setError("Masukkan user code!");
            }

            if (TextUtils.isEmpty(user_pass)) {
                etUser_Pass.setError("Masukkan user_pass!");
            }

            return false;
        }

        return true;
    }

    private void loginUser(final String user_code, String user_pass) {
        loginLoading.show();
         try {
            Call<LoginResponses> call = RetrofitServices.sendDataRequest().loginUser(user_code, user_pass);
            call.enqueue(new Callback<LoginResponses>() {
                @Override
                public void onResponse(Call<LoginResponses> call, Response<LoginResponses> response) {
                    loginLoading.dismiss();

                    if (response.isSuccessful()) {
                        boolean error = response.body().getError();
                        String msg = response.body().getMsg();

                        if (!error) {
                            StoreModel storeModel = response.body().getDataStore();
                            sharedPreference.storeData("dataStore", storeModel);
                            //Toast.makeText(getApplicationContext(), "Welcome To Mobile Reporting System  " + storeModel.getStoreName(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "Welcome To Enji Mobile Reporting System ", Toast.LENGTH_SHORT).show();

                          startActivity(new Intent(LoginActivity.this, MainActivity.class));
                           // finish();
                        } else {
                            Toast toast = Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 90);
                            toast.show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Server On Maintenance, Try Again Later !", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponses> call, Throwable t) {
                    loginLoading.dismiss();
                    Log.d("error", "onFailure: " + t.getMessage());
                    Toast toast = Toast.makeText(getApplicationContext(), "Error Connecting To Server ...!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
              }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
