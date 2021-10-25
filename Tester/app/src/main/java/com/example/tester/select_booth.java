package com.example.tester;

public class select_booth extends zone {
    private static String booth_type;
    private static int booth_id;

    public void setBooth_type(String booth_type){  // ใช้ตรงหน้าเลือก booth เก้บตอน users action กับ ปุ่ม
        this.booth_type= booth_type;
    }
    public String getBooth_type(){
        return booth_type;
    }
    public void setBooth_id(int booth_id){ // action ตอน users เลือก booth ที่ต้องการ
        this.booth_id= booth_id;
    }
    public int getBooth_id(){
        return booth_id;
    }

}
