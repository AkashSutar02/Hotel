package hotel;

import java.sql.SQLException;

public interface HotelManage {
    void update_data(String today, String itm, int price);


    void insert_Data(String tableName, String item_Name, double price);
        void remove_Data(String tableName, String item);

    void Display_Data(String tablename);
    void userDatails();
}
