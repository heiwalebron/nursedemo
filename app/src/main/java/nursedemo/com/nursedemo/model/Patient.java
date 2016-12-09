package nursedemo.com.nursedemo.model;

/**
 * Created by Administrator on 2016/11/25/025.
 */
public class Patient {
    String bingli_NO,
            bed_NO,
            name,
            gender,
            age,
            kebie,yizhu_lx,ncg,nl,diet,condition,wowei,
            fa_yao_p,
            hedui,
            excute;

    public Patient(String bingli_NO, String bed_NO, String name, String gender, String age, String kebie) {
        this.bingli_NO = bingli_NO;
        this.bed_NO = bed_NO;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.kebie = kebie;
    }

    public Patient(String bingli_NO, String bed_NO, String name, String gender, String age, String kebie, String fa_yao_p) {
        this.bingli_NO = bingli_NO;
        this.bed_NO = bed_NO;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.kebie = kebie;
        this.fa_yao_p = fa_yao_p;
    }

    public Patient(String bingli_NO, String bed_NO, String name, String gender, String age, String kebie, String fa_yao_p, String hedui) {
        this.bingli_NO = bingli_NO;
        this.bed_NO = bed_NO;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.kebie = kebie;
        this.fa_yao_p = fa_yao_p;
        this.hedui = hedui;
    }


    public Patient(String bingli_NO, String bed_NO, String name, String gender, String age, String fa_yao_p, String hedui, String excute, String kebie) {
        this.bingli_NO = bingli_NO;
        this.bed_NO = bed_NO;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.fa_yao_p = fa_yao_p;
        this.hedui = hedui;
        this.excute = excute;
        this.kebie = kebie;
    }

    public Patient(String bingli_NO, String bed_NO, String name, String gender, String age, String kebie, String yizhu_lx, String ncg, String nl, String diet, String condition, String wowei) {
        this.bingli_NO = bingli_NO;
        this.bed_NO = bed_NO;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.kebie = kebie;
        this.yizhu_lx = yizhu_lx;
        this.ncg = ncg;
        this.nl = nl;
        this.diet = diet;
        this.condition = condition;
        this.wowei = wowei;
    }

    public String getBingli_NO() {
        return bingli_NO;
    }

    public void setBingli_NO(String bingli_NO) {
        this.bingli_NO = bingli_NO;
    }

    public String getBed_NO() {
        return bed_NO;
    }

    public void setBed_NO(String bed_NO) {
        this.bed_NO = bed_NO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKebie() {
        return kebie;
    }

    public void setKebie(String kebie) {
        this.kebie = kebie;
    }

    public String getYizhu_lx() {
        return yizhu_lx;
    }

    public void setYizhu_lx(String yizhu_lx) {
        this.yizhu_lx = yizhu_lx;
    }

    public String getNcg() {
        return ncg;
    }

    public void setNcg(String ncg) {
        this.ncg = ncg;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWowei() {
        return wowei;
    }

    public void setWowei(String wowei) {
        this.wowei = wowei;
    }

    public String getFa_yao_p() {
        return fa_yao_p;
    }

    public void setFa_yao_p(String fa_yao_p) {
        this.fa_yao_p = fa_yao_p;
    }

    public String getHedui() {
        return hedui;
    }

    public void setHedui(String hedui) {
        this.hedui = hedui;
    }

    public String getExcute() {
        return excute;
    }

    public void setExcute(String excute) {
        this.excute = excute;
    }
}
