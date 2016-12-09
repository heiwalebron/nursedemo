package nursedemo.com.nursedemo.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 这个类就是实现从assets目录读取数据库文件然后写入SDcard中,如果在SDcard中存在，就打开数据库，不存在就从assets目录下复制过去
 * Created by Administrator on 2016/11/26/026.
 */
public class ReadSQL {
    //数据库存储路径
    String filePath = "data/data/nursedemo.com.nursedemo/yizhudemo.db";
    //数据库存放的文件夹 data/data/nursedemo.com.nursedemo下面
    String pathStr = "data/data/nursedemo.com.nursedemo";
    SQLiteDatabase database;

    public  SQLiteDatabase openDatabase(Context context){
        File jhPath=new File(filePath);
        //查看数据库文件是否存在
        if (jhPath.exists()){
            return SQLiteDatabase.openOrCreateDatabase(jhPath, null);
        }else {
            //不存在先创建文件夹
            File path=new File(pathStr);
            if (path.mkdir()){
                Log.i("test", "创建成功");
            }else{
                Log.i("test", "创建失败");
            };
            try {
            //得到资源
            AssetManager am= context.getAssets();
            //得到数据库的输入流
                InputStream is=am.open("yizhudemo.db");
                Log.i("test", is+"");
                //用输出流写到SDcard上面
                FileOutputStream fos=new FileOutputStream(jhPath);
                Log.i("test", "fos="+fos);
                Log.i("test", "jhPath="+jhPath);
                //创建byte数组  用于1KB写一次
                byte[] buffer=new byte[1024];
                int count = 0;
                while((count = is.read(buffer))>0){
                    Log.i("test", "得到");
                    fos.write(buffer,0,count);
                }
                //最后关闭就可以了
                fos.flush();
                fos.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return openDatabase(context);
        }


    }
}

