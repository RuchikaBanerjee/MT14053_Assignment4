package com.example.ruchika.test4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    Button btnsignup;
    String username;
    String password;
    //RadioGroup rg;
    String usertype;
    EditText editusername,editpassword;
    int flag= 0;
    ArrayList<ArrayList<String>> MainList = new ArrayList<ArrayList<String>>(10);
    public static final String TAG = " hello";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String s = " ";
        String t = "Ohooo";
       /* RestClient R = new RestClient();
        try {
            s = R.testfile(t);
            Log.i(TAG,"Ruchika");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        Log.i(TAG,s);
        /*RestClient.get().getWeather("California", new Callback<WeatherResponse>() {
            @Override
            public void success(WeatherResponse weatherResponse, Response response) {
                // success!
                Log.i("App", weatherResponse.getBase());
                Log.i("App", weatherResponse.getWeather().getMain());
                Log.i("App", weatherResponse.getWeather().getDescription());
                // you get the point...
            }

            @Override
            public void failure(RetrofitError error) {
                // something went wrong
            }
        });*/

    }

    public void getvalues(){

        btnsignup = (Button) findViewById(R.id.btnusertype);
        editusername = (EditText) findViewById(R.id.editusername);
        username = editusername.getText().toString();
        editpassword = (EditText) findViewById(R.id.editpwd);
        password = editpassword.getText().toString();
        //rg = (RadioGroup) findViewById(R.id.rg);
        //usertype = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
    }

    public void register(View v) {

        getvalues();
        for (int i = 0; i < MainList.size(); i++){
            if (username.contentEquals(MainList.get(i).get(0))) {

                flag = 1;
            }
        }
        if(flag == 0){

            ArrayList<String> list = new ArrayList<String>();
            list.add(username);
            list.add(password);
            list.add(usertype);
            MainList.add(list);
            Toast.makeText(getApplicationContext(),"Thanks for registering", Toast.LENGTH_SHORT).show();
            Intent uploadfiles = new Intent(this, UploadFiles.class);
            startActivity(uploadfiles);

        }

    }
    public void Clear(View v){

        getvalues();
        editpassword.getText().clear();
        editusername.getText().clear();
        //rg.clearCheck();

    }
    public void Details(View v){

        for(int i=0; i<MainList.size();i++){
            Toast.makeText(getApplicationContext(), MainList.get(i).toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
