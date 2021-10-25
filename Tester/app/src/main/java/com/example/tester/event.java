package com.example.tester;

 public abstract class event implements base {
    private static int event_id;    // ใช้ตรงส่วนฟีตหน้าที่ user เลือก event ให้ set ลงไปด้วยเพื่อเรียกใช้ตอนส่งข้อมูล
    @Override
    public void setEvent(int event_id) {
        this.event_id = event_id;
    }

    @Override
    public int getEvent() {
        return event_id;
    }
    abstract public void setZone(int zone);
    abstract public int getZone();
}
