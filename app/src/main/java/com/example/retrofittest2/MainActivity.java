package com.example.retrofittest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.retrofittest2.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textview);

        Call<User> call = RetrofitClientInstance.getInstance().getApi().getAllUsers();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

//                if (!response.isSuccessful()){
//                    Log.d("Apicall",":not success:"+ response.code());
//                    textViewResult.setText("Code: " + response.code());
//                    return;
//                }

                if(response.code() == 200)
                {
                    User users =response.body();
                    Log.d("Apicall",":users:"+ response.body());

                    String content ="";
                    content += "Name: " +users.getUser1().getName() + "\n";
                    content += "profession: " + users.getUser1().getProfession() + "\n\n";
                    content += "Name: " +users.getUser2().getName() + "\n";
                    content += "profession: " + users.getUser2().getProfession() + "\n\n";
                    content += "Name: " +users.getUser3().getName() + "\n";
                    content += "profession: " + users.getUser3().getProfession() + "\n\n";

                    textViewResult.append(content);
                    Log.d("Apicall",":success");
                }
                else
                {
                    Log.d("Apicall",":not success:"+ response.code());
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Apicall",":failure:"+t.getMessage());
                textViewResult.setText(t.getMessage());

            }
        });
    }
}
