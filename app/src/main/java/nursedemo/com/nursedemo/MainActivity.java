package nursedemo.com.nursedemo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import nursedemo.com.nursedemo.model.Patient;
import nursedemo.com.nursedemo.model.PatientAdapter;
import nursedemo.com.nursedemo.model.ReadSQL;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    Spinner send_site;
    ListView lv_nurse;

    ReadSQL redSQL;

    PatientAdapter patientArrayAdapter;
    ArrayList<Patient> patientArrayList;

    TextView empID;
    TextView empBed;
    TextView empName;
    TextView empGender;
    TextView empAge;
    TextView empKB;
    TextView empFY;

    String bingli_NO;
    String bed_NO;
    String patient_name;
    String gender;
    String age;
    String kebie;
    Patient patient;

    Button bn_excute;
    Button bn_check;
    Button send;

    public static final String EXTRA_MESSAGE2 ="lebron2";
    public static final String EXTRA_MESSAGE1 = "lebron1";
    public static final String EXTRA_MESSAGE3 = "lebron3";
    public static final String EXTRA_MESSAGE4 = "lebron4";
    public static final String EXTRA_MESSAGE5 = "lebron5";
    public static final String EXTRA_MESSAGE6 = "lebron6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        send_site=(Spinner)findViewById(R.id.send_site);
        ArrayAdapter<CharSequence> adapterdrug_send=  ArrayAdapter.createFromResource(this, R.array.drug_send, android.R.layout.simple_spinner_item);
        adapterdrug_send.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        send_site.setAdapter(adapterdrug_send);
        bn_excute=(Button)findViewById(R.id.bn_excute);
        bn_check=(Button)findViewById(R.id.bn_check);
        send=(Button)findViewById(R.id.send);
        bn_excute.setOnClickListener(this);
        bn_check.setOnClickListener(this);
        send.setOnClickListener(this);

        lv_nurse=(ListView)findViewById(R.id.lv_nurse);

        patientArrayList=new ArrayList<Patient>();
       /* patientArrayList.add(new Patient("001","028-6","张三","男","45","内科"));
        patientArrayList.add(new Patient("002","028-1","李四","男","35","内科"));
        patientArrayList.add(new Patient("003","028-2","王二","男","43","内科"));
        patientArrayList.add(new Patient("004","028-3","小明","男","55","内科"));*/
        /*
        * 将数据库中查询的数据放入实体类中
        * */
        redSQL=new ReadSQL();

        SQLiteDatabase db =redSQL.openDatabase(getApplicationContext());
        Cursor cursor = db.rawQuery("select bingli_NO,bed_NO,name,gender,age,kebie from patient",null);
        while (cursor.moveToNext()){
            bingli_NO = cursor.getString(cursor.getColumnIndex("bingli_NO"));
            bed_NO = cursor.getString(cursor.getColumnIndex("bed_NO"));
            patient_name = cursor.getString(cursor.getColumnIndex("name"));
            gender = cursor.getString(cursor.getColumnIndex("gender"));
            age = cursor.getString(cursor.getColumnIndex("age"));
            kebie = cursor.getString(cursor.getColumnIndex("kebie"));

            patient=new Patient(bingli_NO,bed_NO,patient_name,gender,age,kebie);

            /*patient.setBingli_NO(bingli_NO);
            patient.setBed_NO(bed_NO);
            patient.setName(patient_name);
            patient.setGender(gender);
            patient.setAge(age);
            patient.setKebie(kebie);*/

            patientArrayList.add(patient);

        }


        patientArrayAdapter=new PatientAdapter(this,patientArrayList);
        lv_nurse.setAdapter(patientArrayAdapter);

        lv_nurse.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        empID = (TextView) view.findViewById(R.id.tv1);
        String getEmpID = empID.getText().toString();
        empBed = (TextView) view.findViewById(R.id.tv2);
        String getEmpBed = empBed.getText().toString();
        empName=(TextView)view.findViewById(R.id.tv3);
        String getEmpName = empName.getText().toString();
        empGender = (TextView) view.findViewById(R.id.tv4);
        String getEmpGender = empGender.getText().toString();
        empAge = (TextView) view.findViewById(R.id.tv5);
        String getEmpAge = empAge.getText().toString();
        empKB = (TextView) view.findViewById(R.id.tv6);
        String getEmpKB = empKB.getText().toString();
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE1, getEmpID);
        intent.putExtra(EXTRA_MESSAGE2, getEmpBed);
        intent.putExtra(EXTRA_MESSAGE3, getEmpName);
        intent.putExtra(EXTRA_MESSAGE4, getEmpGender);
        intent.putExtra(EXTRA_MESSAGE5, getEmpAge);
        intent.putExtra(EXTRA_MESSAGE6, getEmpKB);
        //startActivity(intent);
        startActivityForResult(intent,1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data == null) {
            Toast.makeText(getApplicationContext(), "没完成！", Toast.LENGTH_SHORT).show();
        } else {
            String firstname = data.getExtras().getString("firstname");
            Toast.makeText(getApplicationContext(), firstname, Toast.LENGTH_SHORT).show();
        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.check:
                Intent intent1=new Intent(this,CheckActivity.class);
                startActivity(intent1);
                break;
            case R.id.excute:
                Intent intent2=new Intent(this,ExcuteActivity.class);
                startActivity(intent2);
                break;
        }
        return true;
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bn_excute:

                Intent intent1=new Intent(this,CheckActivity.class);

                startActivity(intent1);

                break;

            case R.id.bn_check:

                Intent intent2=new Intent(this,ExcuteActivity.class);

                startActivity(intent2);

                break;

            case R.id.send:

                break;

        }

    }
}
