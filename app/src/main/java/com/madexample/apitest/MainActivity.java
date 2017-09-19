package com.madexample.apitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    Button b1;
    TextView username, name, gender, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.ed1);
        b1 = (Button) findViewById(R.id.but1);
        username = (TextView) findViewById(R.id.username);
        name = (TextView) findViewById(R.id.name);
        gender = (TextView) findViewById(R.id.gender);
        dob = (TextView) findViewById(R.id.dob);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ProfileModel> profileCall = APIClient.getAPIInterface().getProfileList(et1.getText().toString());
                Log.d("Main activity", "Onclick");
                profileCall.enqueue(new Callback<ProfileModel>() {
                    @Override
                    public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                        ProfileModel model = response.body();
                        Log.d("Main activity", "Response");
                        Boolean success = false;

                        try {
                            success = model.getSuccess().equals("true");
                        } catch (Exception e) {
                            success = true;
                        }


                        if (success) {
                            username.setText(model.getUsername());
                            name.setText(model.getName());
                            gender.setText(model.getGender());
                            dob.setText(model.getDob());
                            Address addr = model.getAdd();
                            Toast.makeText(MainActivity.this, addr.getCity()+addr.getState()+addr.getCountry()+addr.getPincode(), Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(MainActivity.this, "Not Found", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ProfileModel> call, Throwable t) {
                        Log.d("Main activity", t.toString());

                    }
                });
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postReq("SS");
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProj("SS11","test1");
            }
        });
    }




    public void postReq(String key){
        APIClient.getAPIInterface().searchProfile("SS").enqueue(new Callback<Post[]>() {
            @Override
            public void onResponse(Call<Post[]> call, Response<Post[]> response) {

                if(response.isSuccessful()) {
                    Post[] post = response.body();
                    for(int i=0;i<post.length;i++)
                    Toast.makeText(MainActivity.this, post[i].getName(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post[]> call, Throwable t) {
                Log.e("TAG", t.toString());
            }

        });
    }

    public void login(String uname, String pass){
        APIClient.getAPIInterface().login(uname,pass).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                if(response.isSuccessful()) {
                    Login logg = response.body();

                        Toast.makeText(MainActivity.this, logg.getSuccess(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Log.e("TAG", t.toString());
            }

        });
    }

    public void addProj(String uname, String pname){
        String tags[]={"java","test"};
        String lang[] = {"java","eng"};
        APIClient.getAPIInterface().addProject(uname,pname,tags,lang,"hello",Boolean.TRUE).enqueue(new Callback<Project>() {
            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {

//                if(response.isSuccessful()) {
                    Project logg = response.body();

                    Toast.makeText(MainActivity.this, logg.getMessage(), Toast.LENGTH_SHORT).show();
                //}
            }

            @Override
            public void onFailure(Call<Project> call, Throwable t) {
                Log.e("TAG", t.toString());
            }

        });
    }



}
