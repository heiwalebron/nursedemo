package nursedemo.com.nursedemo.model;

/**
 * Created by Administrator on 2016/11/25/025.
 */
public class YiZhu {
    String day,
            starttime,
            yizhu,
            way,
            yishi,
            fa_yao_p,
            time,
            name;

    public YiZhu(String day, String starttime, String yizhu, String way, String yishi, String fa_yao_p) {
        this.day = day;
        this.starttime = starttime;
        this.yizhu = yizhu;
        this.way = way;
        this.yishi = yishi;
        this.fa_yao_p = fa_yao_p;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFa_yao_p() {
        return fa_yao_p;
    }

    public void setFa_yao_p(String fa_yao_p) {
        this.fa_yao_p = fa_yao_p;
    }

    public String getYishi() {
        return yishi;
    }

    public void setYishi(String yishi) {
        this.yishi = yishi;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getYizhu() {
        return yizhu;
    }

    public void setYizhu(String yizhu) {
        this.yizhu = yizhu;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }
}