package com.logixcess.republiccargo.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

//public class User
//{
//    @SerializedName("id")
//    String id;
//    @SerializedName("name")
//    String name;
//    @SerializedName("address")
//    String address;
//    @SerializedName("cell_no")
//    String cell_no;
//    @SerializedName("email")
//    String email;
//    @SerializedName("password")
//    String password;
//    @SerializedName("type")
//    String type;
//    @SerializedName("image")
//    String image;
//    @SerializedName("is_login")
//    Boolean is_login;
//
//    public User(String id, String name, String address, String cell_no, String email, String password, String type, String image, Boolean is_login) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.cell_no = cell_no;
//        this.email = email;
//        this.password = password;
//        this.type = type;
//        this.image = image;
//        this.is_login = is_login;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getCell_no() {
//        return cell_no;
//    }
//
//    public void setCell_no(String cell_no) {
//        this.cell_no = cell_no;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public Boolean getIs_login() {
//        return is_login;
//    }
//
//    public void setIs_login(Boolean is_login) {
//        this.is_login = is_login;
//    }
//}


public class User
{

    @SerializedName("id")
    int id;
    @SerializedName("email_verified_at")
    Date email_verified_at;
    @SerializedName("bio")
    String bio;
    @SerializedName("photo")
    String photo;
    @SerializedName("name")
    String name;
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;
    @SerializedName("type")
    String type;

    public User(String name, String email, String password, String type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(Date email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
