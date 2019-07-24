package com.logixcess.republiccargo.models;

import android.location.Location;

public class Box
{
    String sender_name;
    String receiver_name;
    String sender_address;
    String sender_phone;
    String sender_address_map;
    String receiver_address;
    String receiver_phone;
    String receiver_address_map;

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getSender_address() {
        return sender_address;
    }

    public void setSender_address(String sender_address) {
        this.sender_address = sender_address;
    }

    public String getSender_address_map() {
        return sender_address_map;
    }

    public void setSender_address_map(String sender_address_map) {
        this.sender_address_map = sender_address_map;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public String getReceiver_address_map() {
        return receiver_address_map;
    }

    public void setReceiver_address_map(String receiver_address_map) {
        this.receiver_address_map = receiver_address_map;
    }

    public String getSender_phone() {
        return sender_phone;
    }

    public void setSender_phone(String sender_phone) {
        this.sender_phone = sender_phone;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }
}
