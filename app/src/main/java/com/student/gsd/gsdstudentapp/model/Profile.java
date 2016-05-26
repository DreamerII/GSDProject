package com.student.gsd.gsdstudentapp.model;


import android.graphics.Bitmap;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by dreamfire on 25.05.16.
 */
public class Profile extends RealmObject {
    private int userID;
    private int bDay;
    private int bMonth;
    private int bYear;
    private int gender;
    private String city;
    private String ocity;
    private int phonea;
    private int phoneb;
    private int studylevel;
    private int ostudylevel;
    private int studentid;
    private String institutid;
    private int oinstitute;
    private String nationality;
    private int onationality;
    @Ignore
    private Bitmap fileToUpload;

//    private Context mContext;
//    private static Profile sProfile;
//
//    public static Profile newInstance(){
//        if(sProfile == null)
//            sProfile = new Profile();
//        return sProfile;
//    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getbDay() {
        return bDay;
    }

    public void setbDay(int bDay) {
        this.bDay = bDay;
    }

    public int getbMonth() {
        return bMonth;
    }

    public void setbMonth(int bMonth) {
        this.bMonth = bMonth;
    }

    public int getbYear() {
        return bYear;
    }

    public void setbYear(int bYear) {
        this.bYear = bYear;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOcity() {
        return ocity;
    }

    public void setOcity(String ocity) {
        this.ocity = ocity;
    }

    public int getPhonea() {
        return phonea;
    }

    public void setPhonea(int phonea) {
        this.phonea = phonea;
    }

    public int getPhoneb() {
        return phoneb;
    }

    public void setPhoneb(int phoneb) {
        this.phoneb = phoneb;
    }

    public int getStudylevel() {
        return studylevel;
    }

    public void setStudylevel(int studylevel) {
        this.studylevel = studylevel;
    }

    public int getOstudylevel() {
        return ostudylevel;
    }

    public void setOstudylevel(int ostudylevel) {
        this.ostudylevel = ostudylevel;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getInstitutid() {
        return institutid;
    }

    public void setInstitutid(String institutid) {
        this.institutid = institutid;
    }

    public int getOinstitute() {
        return oinstitute;
    }

    public void setOinstitute(int oinstitute) {
        this.oinstitute = oinstitute;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getOnationality() {
        return onationality;
    }

    public void setOnationality(int onationality) {
        this.onationality = onationality;
    }

    public Bitmap getFileToUpload() {
        return fileToUpload;
    }

    public void setFileToUpload(Bitmap fileToUpload) {
        this.fileToUpload = fileToUpload;
    }
}
