package com.example.tester;

public class zone extends event {
    private static int zone;       //ใช้ตอนที่ user action ไปที่ map ก่อนจะ intent ให้เก็บ zone ไว้ด้วย
    @Override
    public void setZone(int zone) {
        this.zone = zone;
    }

    @Override
    public int getZone() {
        return zone;
    }
}
