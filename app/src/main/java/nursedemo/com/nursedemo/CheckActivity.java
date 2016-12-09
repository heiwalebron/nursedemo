package nursedemo.com.nursedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import nursedemo.com.nursedemo.model.Patient;
import nursedemo.com.nursedemo.model.PatientAdapter;
import nursedemo.com.nursedemo.model.PatientAdapter_check;
import nursedemo.com.nursedemo.model.ReadSQL;

/**
 * Created by Administrator on 2016/11/28/028.
 */
public class CheckActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    public static final String EXTRA_MESSAGE3 = "lebron3";

    ListView lv_check;

    Button check;


    ReadSQL redSQL;

    String bingli_NO;
    String bed_NO;
    String patient_name;
    String gender;
    String age;
    String kebie;
    String fa_yao_p;
    String hedui;

    TextView empName;


    ArrayList<Patient> patientArrayList;
    PatientAdapter_check patientArrayAdapter;
    Patient patient;

    Cursor cursor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nurse_3);

        lv_check=(ListView)findViewById(R.id.lv_check);

        check=(Button)findViewById(R.id.check);
        check.setOnClickListener(this);



        patientArrayList=new ArrayList<Patient>();
        redSQL=new ReadSQL();

        SQLiteDatabase db =redSQL.openDatabase(getApplicationContext());
        Cursor cursor = db.rawQuery("select bingli_NO,bed_NO,name,gender,age,kebie,fa_yao_p,hedui from patient",null);
        while (cursor.moveToNext()) {
            bingli_NO = cursor.getString(cursor.getColumnIndex("bingli_NO"));
            bed_NO = cursor.getString(cursor.getColumnIndex("bed_NO"));
            patient_name = cursor.getString(cursor.getColumnIndex("name"));
            gender = cursor.getString(cursor.getColumnIndex("gender"));
            age = cursor.getString(cursor.getColumnIndex("age"));
            kebie = cursor.getString(cursor.getColumnIndex("kebie"));
            fa_yao_p=cursor.getString(cursor.getColumnIndex("fa_yao_p"));
            hedui=cursor.getString(cursor.getColumnIndex("hedui"));

            patient=new Patient(bingli_NO,bed_NO,patient_name,gender,age,kebie,fa_yao_p);
            patientArrayList.add(patient);
        }
        cursor.close();

        patientArrayAdapter=new PatientAdapter_check(this,patientArrayList);
        lv_check.setAdapter(patientArrayAdapter);
        lv_check.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.check:



                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        empName=(TextView)view.findViewById(R.id.tv3);
        String getEmpName = empName.getText().toString();
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE3, getEmpName);
        startActivity(intent);

    }
}
