package com.example.dbds_minip;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    /*public Button b1;
    public RadioGroup rg;
    public RadioButton db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button);
        rg = (RadioGroup) findViewById(R.id.radioGroupDB);
        String dbName = "ABC_Retail";

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = rg.getCheckedRadioButtonId();
                db = (RadioButton) findViewById(selectedId);
                String dbText = db.getText().toString();;

                onButtonClick((Button) view, dbText);
            }
        });
        super.onCreate(savedInstanceState);*/

        public Button b1;
        public EditText e1;
        public Spinner spDatabases;
        public RadioButton db;
        public RadioGroup rg;
        public TextView t1;
        public TableLayout tableLayout;
        public ScrollView scrollView;


        ArrayAdapter<CharSequence> adapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            setContentView(R.layout.activity_main);
            b1= findViewById(R.id.runButton);
            e1= findViewById(R.id.editQuery);
            rg= findViewById(R.id.radioGroupDB);
            tableLayout = findViewById(R.id.tableLayout);
            scrollView = findViewById(R.id.scrollView2);

            adapter=ArrayAdapter.createFromResource(this, R.array.databases, R.layout.simple_spinner_dropdown );
            spDatabases= findViewById(R.id.spinner_db_selector);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spDatabases.setAdapter(adapter);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    scrollView.setVisibility(View.VISIBLE);
                    String s1 = e1.getText().toString();
                    int selectedId = rg.getCheckedRadioButtonId();
                    db = findViewById(selectedId);
                    String dbText = db.getText().toString();
                    String dbSelect = spDatabases.getSelectedItem().toString();
                    tableLayout.removeViews(0, tableLayout.getChildCount());
                    //call API
                    onButtonClick((Button) view, dbText, dbSelect);
                    System.out.println(s1+" "+dbText+" "+dbSelect);
                }
            });
            super.onCreate(savedInstanceState);
    }

    public void fillTable(JSONArray jsonArr) throws JSONException {
        Integer count = 0;
        //String data = "[{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"barcode\": \"sandeep\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"lahdlakdjslakj\",\"abce\":\"lahdlakdjslakj\"},{\"userName\": \"vivan\",\"abc\":\"lahdlakdjslakj\",\"abcd\":\"dfhksjdfsjh\",\"abce\":\"lahdlakdjslakj\"}]  ";
        //JSONArray jsonArr = new JSONArray(data);
        ShapeDrawable border = new ShapeDrawable(new RectShape());
        border.getPaint().setStyle(Paint.Style.STROKE);
        border.getPaint().setColor(Color.BLACK);

        JSONObject jo1 = jsonArr.getJSONObject(0);
        TableRow tableRow1 = new TableRow(MainActivity.this);
        tableRow1.setId(View.generateViewId());
        tableRow1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tableRow1.setBackgroundColor(getResources().getColor(android.R.color.background_dark));
        for (Iterator<String> it = jo1.keys(); it.hasNext(); ) {
            String key = it.next();
            TextView currLabel = new TextView(MainActivity.this);
            currLabel.setId(View.generateViewId());
            currLabel.setGravity(Gravity.CENTER);
            currLabel.setPadding(10, 5, 10, 5);
            currLabel.setTextColor(getResources().getColor(R.color.colorAccent));
            currLabel.setTextSize(18);
            currLabel.setText(key.toString());
            currLabel.setBackground(border);
            tableRow1.addView(currLabel);
        }
        tableLayout.addView(tableRow1, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


        for(int i = 0; i<jsonArr.length(); i++){
            JSONObject jo = jsonArr.getJSONObject(i);
            TableRow tableRow = new TableRow(MainActivity.this);
            tableRow.setId(View.generateViewId());
            tableRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            if (i % 2 != 0) {
                tableRow.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            }
            for (Iterator<String> it = jo.keys(); it.hasNext(); ) {
                String key = it.next();
                TextView currLabel = new TextView(MainActivity.this);
                currLabel.setId(View.generateViewId());
                currLabel.setGravity(Gravity.CENTER);
                currLabel.setPadding(10, 5, 10, 5);
                //labelBarcode.setTextColor(getResources().getColor(R.color.colorAccent));
                currLabel.setTextSize(18);
                currLabel.setText(jo.get(key).toString());
                currLabel.setBackground(border);
                tableRow.addView(currLabel);
            }
            tableLayout.addView(tableRow, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        /*for (int i = 0; i < 100; i++) {

            String barcode = "#0000000000";
            String location = "Locationas";
            Integer quantity = 1;
            String other = "another string";



            TableRow tableRow = new TableRow(MainActivity.this);
            if (count % 2 != 0) {
                tableRow.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            }
            tableRow.setId(View.generateViewId());
            tableRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            TextView labelBarcode = new TextView(MainActivity.this);
            labelBarcode.setId(View.generateViewId());
            labelBarcode.setGravity(Gravity.CENTER);
            //labelBarcode.setTextColor(getResources().getColor(R.color.colorAccent));
            labelBarcode.setTextSize(18);
            labelBarcode.setText(barcode);
            labelBarcode.setBackground(border);
            tableRow.addView(labelBarcode);

            TextView labelLocation = new TextView(MainActivity.this);
            labelLocation.setId(View.generateViewId());
            labelLocation.setGravity(Gravity.CENTER);
            //labelLocation.setTextColor(getResources().getColor(R.color.colorAccent));
            labelLocation.setTextSize(18);
            labelLocation.setText(location);
            labelLocation.setBackground(border);
            tableRow.addView(labelLocation);

            TextView labelQuantity = new TextView(MainActivity.this);
            labelQuantity.setId(View.generateViewId());
            labelQuantity.setGravity(Gravity.CENTER);
            //abelQuantity.setTextColor(getResources().getColor(R.color.colorAccent));
            labelQuantity.setTextSize(18);
            labelQuantity.setText(quantity.toString());
            labelQuantity.setBackground(border);
            tableRow.addView(labelQuantity);

            TextView labelNew = new TextView(MainActivity.this);
            labelNew.setId(View.generateViewId());
            labelNew.setGravity(Gravity.CENTER);
            //labelNew.setTextColor(getResources().getColor(R.color.colorAccent));
            labelNew.setTextSize(18);
            labelNew.setText(other.toString());
            labelNew.setBackground(border);
            tableRow.addView(labelNew);

            tableLayout.addView(tableRow, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            count++;
        }*/
    }

    private void initializeTableLayout() {
        tableLayout = this.findViewById(R.id.tableLayout);
        TableRow tr_head = new TableRow(MainActivity.this);
        tr_head.setId(View.generateViewId());
        tr_head.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        tr_head.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView label_barcode = new TextView(MainActivity.this);
        label_barcode.setId(View.generateViewId());
        label_barcode.setText("BARCODE");
        label_barcode.setTextSize(20);
        label_barcode.setTextColor(Color.BLACK);
        label_barcode.setGravity(Gravity.CENTER);
        tr_head.addView(label_barcode);// add the column to the table row here

        TextView label_location = new TextView(MainActivity.this);
        label_location.setId(View.generateViewId());// define id that must be         unique
        label_location.setText("LOCATION"); // set the text for the header
        label_location.setTextSize(20);
        label_location.setTextColor(Color.BLACK); // set the color
        label_location.setGravity(Gravity.CENTER);
        tr_head.addView(label_location); // add the column to the table row here

        TextView label_quantity = new TextView(MainActivity.this);
        label_quantity.setId(View.generateViewId());// define id that must be         unique
        label_quantity.setText("QTY"); // set the text for the header
        label_quantity.setTextSize(20);
        label_quantity.setTextColor(Color.BLACK); // set the color
        label_quantity.setGravity(Gravity.CENTER);
        tr_head.addView(label_quantity); // add the column to the table row here

        TextView label_new = new TextView(MainActivity.this);
        label_new.setId(View.generateViewId());// define id that must be         unique
        label_new.setText("NEW"); // set the text for the header
        label_new.setTextSize(20);
        label_new.setTextColor(Color.BLACK); // set the color
        label_new.setGravity(Gravity.CENTER);
        tr_head.addView(label_new); // add the column to the table row here

        tableLayout.setScrollContainer(true);
        tableLayout.addView(tr_head, new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void onButtonClick(Button view, String dbText, String dbSelect) {
        //EditText outputEdit = findViewById(R.id.editOutput);
        EditText queryView = findViewById(R.id.editQuery);
        String query = queryView.getText().toString();

        //outputEdit.setText("Clicked !!! "+dbText);
        long start = System.nanoTime();
        JSONObject payload = null, initP =null;
        String dbInst = "instacart";
        System.out.println(dbSelect.toLowerCase());
        if(!dbSelect.toLowerCase().equals("instacart")) dbInst = "ABC_Retail" ;

        try {
            payload = new JSONObject("{Query:\""+query +"\",Name:\""+dbInst+"\",DB:\""+dbText.toUpperCase()+"\"}");
            //initP = new JSONObject("use "+dbInst);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        CallDb callDb = new CallDb(getString(R.string.domain_url),
                payload,
                "POST");
        //CallDb callDb = new CallDb(getString(R.string.domain_url));
        //CallDb callDb = new CallDb("http://ec2-54-84-50-216.compute-1.amazonaws.com:5000/api/healthcheck/REDSHIFT", "", "GET");
        callDb.execute();
        long finish = System.nanoTime();
        t1 = (TextView) findViewById(R.id.timeElapsedView);
        t1.setText("Processed successfully! The operation took "+String.valueOf((finish-start)/100000)+" ms");
    }

    private class CallDb extends AsyncTask<String, String, String> {
        private ProgressDialog progressDialog;
        String myUrl, method;
        JSONObject payload;

        public CallDb(String url, JSONObject data, String method) {
            this.myUrl = url;
            this.payload = data;
            this.method = method;
        }

        public CallDb(String url) {
            this.myUrl = url;
            this.method = "GET";
        }

        @Override
        protected String doInBackground(String... params) {
            String result = "";
            try {
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url = new URL(myUrl);
                    //open a URL connection
                    urlConnection = (HttpURLConnection) url.openConnection();
                    //int statusCode = urlConnection.getResponseCode();

                    if(this.method == "POST"){
                        urlConnection.setDoInput(true);
                        urlConnection.setDoOutput(true);
                        urlConnection.setRequestProperty("Content-Type", "application/json");
                        urlConnection.setRequestMethod(this.method);
                        System.out.println(this.payload.toString());
                        if (this.payload != null) {
                            OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
                            writer.write(this.payload.toString());
                            writer.flush();
                        }
                    }
                    int statusCode = urlConnection.getResponseCode();
                    System.out.println("Status code "+statusCode);

                    if(statusCode ==  200) {
                        InputStream in = urlConnection.getInputStream();
                        InputStreamReader isw = new InputStreamReader(in);
                        int data = isw.read();
                        while (data != -1) {
                            result += (char) data;
                            data = isw.read();
                        }
                        // From here you can convert the string to JSON with whatever JSON parser you like to use
                        // After converting the string to JSON, I call my custom callback. You can follow this process too, or you can implement the onPostExecute(Result) method
                    } else {
                        progressDialog.dismiss();
                        InputStream in = urlConnection.getErrorStream();
                        InputStreamReader isw = new InputStreamReader(in);
                        int data = isw.read();
                        while (data != -1) {
                            result += (char) data;
                            data = isw.read();
                        }
                        System.out.println("INBCKG ERROR O/P --> "+urlConnection.getErrorStream().toString());
                        //result = urlConnection.get().toString();
                    }

                    // return the data to onPostExecute method
                    System.out.println("THe result is --> "+result);
                    return result;

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }

            System.out.println("DOING IN BG --> "+result);
            return result;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experience
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("processing results");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {

            // dismiss the progress dialog after receiving data from API
            progressDialog.dismiss();
            System.out.println("ON POST EXECUTE "+s);
            try {
                JSONArray arr = new JSONArray(s);
                //EditText op = findViewById(R.id.editOutput);
                //op.setText(s);
                System.out.println("QUERY O/P --> "+s);
                JSONObject jsonObject = new JSONObject();
                fillTable(arr);
            } catch (JSONException e) {
                //EditText op = findViewById(R.id.editOutput);
                //op.setText(s);
                System.out.println("QUERY ERROR O/P --> "+s);
                TextView tev = findViewById(R.id.timeElapsedView);
                tev.setText(s);
                progressDialog.dismiss();
            }
        }

        private String convertInputStreamToString(InputStream inputStream) {
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line;
            try {
                while((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }
    }
}