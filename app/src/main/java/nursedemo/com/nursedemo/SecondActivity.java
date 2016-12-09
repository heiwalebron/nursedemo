package nursedemo.com.nursedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import nursedemo.com.nursedemo.model.ReadSQL;
import nursedemo.com.nursedemo.model.YiZhu;
import nursedemo.com.nursedemo.model.YiZhuAdapter;

/**
 * Created by Administrator on 2016/11/26/026.
 */
public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_name,tv_info,tv_time;
    ListView lv_yizhu;
    Button fanhui;
    ArrayList<YiZhu> yiZhuArrayList;
    YiZhuAdapter yiZhuAdapter;

    ReadSQL redSQL;

    String bingli_NO;
    String bed_NO;
    String patient_name;
    String gender;
    String age;
    String kebie;
    String yizhu_lx;
    String ncg;
    String nl;
    String diet;
    String condition;
    String wowei;

    String day;
    String starttime;
    String yizhu;
    String way;
    String yishi;
    String fa_yao_p;
    String time;

    YiZhu yiZhu;

    Cursor cursor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nurse_2);

        tv_name=(TextView)findViewById(R.id.tv_name);
        tv_info=(TextView)findViewById(R.id.tv_info);
        tv_time=(TextView)findViewById(R.id.tv_time);
        lv_yizhu=(ListView)findViewById(R.id.lv_yizhu);
        fanhui=(Button)findViewById(R.id.fanhui);
        fanhui.setOnClickListener(this);

       /* redSQL=new ReadSQL();
        SQLiteDatabase db =redSQL.openDatabase(getApplicationContext());

        Cursor cursor = db.rawQuery("select * from patient where name=?", new String[]{"1"});
*/



        //String bingch=getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE1);
        //String bed=getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE2);
        patient_name=getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE3);
        //String gender=getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE4);
        //String age=getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE5);
       // String kb=getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE6);

        redSQL=new ReadSQL();
        SQLiteDatabase db =redSQL.openDatabase(getApplicationContext());

        cursor = db.rawQuery("select * from patient where name=?", new String[]{patient_name});

        /*
        *
        * 装填详细医嘱1（TextView框）
        * */

        if(cursor.moveToFirst()){
            bingli_NO = cursor.getString(cursor.getColumnIndex("bingli_NO"));
            bed_NO = cursor.getString(cursor.getColumnIndex("bed_NO"));
            patient_name = cursor.getString(cursor.getColumnIndex("name"));
            gender = cursor.getString(cursor.getColumnIndex("gender"));
            age = cursor.getString(cursor.getColumnIndex("age"));
            kebie = cursor.getString(cursor.getColumnIndex("kebie"));
            yizhu_lx = cursor.getString(cursor.getColumnIndex("yizhu_lx"));
            ncg = cursor.getString(cursor.getColumnIndex("ncg"));
            nl = cursor.getString(cursor.getColumnIndex("nl"));
            diet = cursor.getString(cursor.getColumnIndex("diet"));
            condition = cursor.getString(cursor.getColumnIndex("condition"));
            wowei = cursor.getString(cursor.getColumnIndex("wowei"));

        }
        tv_info.setText("病床号："+bingli_NO +"病床："+bed_NO+ "姓名："+patient_name+ "性别："+gender+"\n"+
                "年龄："+age+"科别："+kebie+"医嘱类型："+yizhu_lx+"护理常规："+ncg+"\n"+
                  "护理等级："+nl+"饮食："+diet+"病况："+condition+"特殊卧位："+wowei);
        tv_name.setText(patient_name);




        /*
        * 装填详细医嘱2（ListView框）
        * */

        cursor = db.rawQuery("select day,starttime,yizhu,way,yishi,fa_yao_p,time from yizhu where name=?", new String[]{patient_name});
        yiZhuArrayList=new ArrayList<YiZhu>();
        /*yiZhuArrayList.add(new YiZhu("23/11","9:20","硝苯地平缓释片 20mg","Bid po","宋志霖","柳阳"));
        yiZhuArrayList.add(new YiZhu("23/11","9:20","阿托伐他汀钙片 10mg","Bid po","宋志霖","柳阳"));
        yiZhuArrayList.add(new YiZhu("23/11","9:20","二甲双胝缓释片 0.5g","Bid po","宋志霖","柳阳"));
        yiZhuArrayList.add(new YiZhu("23/11","9:20","奥美拉唑肠溶胶囊 20mg","Bid po","宋志霖","柳阳"));
        yiZhuArrayList.add(new YiZhu("23/11","9:20","复方血栓通胶囊 1.5g","Bid po","宋志霖","柳阳"));
        yiZhuArrayList.add(new YiZhu("23/11","9:20","0.9%注射液 10ml","Bid po","宋志霖","柳阳"));*/
        while (cursor.moveToNext()){
            day=cursor.getString(cursor.getColumnIndex("day"));
            starttime=cursor.getString(cursor.getColumnIndex("starttime"));
            yizhu=cursor.getString(cursor.getColumnIndex("yizhu"));
            way=cursor.getString(cursor.getColumnIndex("way"));
            yishi=cursor.getString(cursor.getColumnIndex("yishi"));
            fa_yao_p=cursor.getString(cursor.getColumnIndex("fa_yao_p"));
            time=cursor.getString(cursor.getColumnIndex("time"));

            yiZhu=new YiZhu(day,starttime,yizhu,way,yishi,fa_yao_p);
            yiZhuArrayList.add(yiZhu);
        }
        tv_time.setText(time);

        yiZhuAdapter=new YiZhuAdapter(this,yiZhuArrayList);

        lv_yizhu.setAdapter(yiZhuAdapter);

        cursor.close();



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fanhui:

                 /*
                *
                * 返回界面1,并在相应的药房发药处显示“完成”
                * */
                Intent i2 = new Intent();
                i2.putExtra("firstname","成功");
                setResult(1, i2);
                finish();



                break;
        }
    }
}
