package com.example.ruchika.test4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class UploadFiles extends Activity {


    ArrayAdapter<String> adapter;
    int clickCounter=0;
    ArrayList<String> listItems=new ArrayList<String>();
    private File[] imagelist;
    String[] pdflist;
     ListView lv;
   //ListView  lv = (ListView) findViewById(R.id.pdflistView);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_files);
        //ListView  lv = (ListView) findViewById(R.id.pdflistView);


        //showPdf();
    }

    public void Search(View v){

        Intent searchpdf = new Intent();
        searchpdf.setType("application/pdf");
        searchpdf.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(searchpdf,"pdf"),0);
        Log.i("ghg", "jjk");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 0:
                {
                    Uri data = result.getData();
                    String pdf = data.toString();
                    String[] pdflist = new String[1];
                    pdflist[0] = pdf;
                    viewpdflist(pdflist);
                }
            }
        }
    }

    public void viewpdflist(String items[] ){

        lv = (ListView) findViewById(R.id.pdflistView);
        ArrayAdapter<String> adapt= new ArrayAdapter<>(this,R.layout.pdf_list_view,items);
       // lv.setAdapter(adapt);
        lv.setAdapter(adapt);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked,
                                    int position, long id) {
                ListView  lv = (ListView) findViewById(R.id.pdflistView);
                // TODO Auto-generated method stub
                TextView textview=(TextView) viewClicked;
                //TextView textview = (TextView) findViewById(R.id.pdf_list_textView);
                String msg= "you clicked : " + textview.getText().toString();
                //Toast.makeText(List.this, position + ":" + id + "", Toast.LENGTH_LONG).show();
                lv.setClickable(false);
                String sele = textview.getText().toString();
                Uri uri = Uri.parse(sele);
                showPdf(uri);
            }
        });
    }



    public void showPdf(Uri uri) {


        Intent intent;
        Toast.makeText(getApplicationContext(), uri.toString(), Toast.LENGTH_SHORT).show();

        intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "application/pdf");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // No application to view, ask to download one
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("No Application Found");
            builder.setMessage("Download one from Android Market?");
            builder.setPositiveButton("Yes, Please",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent marketIntent = new Intent(Intent.ACTION_VIEW);
                            marketIntent
                                    .setData(Uri
                                            .parse("market://details?id=com.adobe.reader"));
                            startActivity(marketIntent);
                        }
                    });
            builder.setNegativeButton("No, Thanks", null);
            builder.create().show();
        }

}}