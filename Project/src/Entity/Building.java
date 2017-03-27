package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Building {

    private int buildingID;
    private String desc;
    private String name;
    private String phone;
    private String email;

    private static void getBuilding(ResultSet rs, Building building) throws SQLException {
        building.setBuildingID(rs.getInt("B_ID"));
        building.setDesc(rs.getString("B_DES"));
        building.setName(rs.getString("B_NAME"));
        building.setPhone(rs.getString("B_PHONE"));
        building.setEmail(rs.getString("B_EMAIL"));
    }
    
    public static void update(int id) {
        System.out.println(showDetailBuild(id));
        Scanner input = new Scanner(System.in);
        boolean check = true;
        String where = "";
        while (check) {
            System.out.print("\nWhere you update \n1.Name\n2.Phone\n3.E-mail\n4.Description\nEnter : ");
            where = input.nextLine();
            if (where.equals("1")) {
                where = "B_NAME";
                check = false;
            } else if (where.equals("2")) {
                where = "B_PHONE";
                check = false;
            } else if (where.equals("3")) {
                where = "B_EMAIL";
                check = false;
            } else if (where.equals("4")) {
                where = "B_DES";
                check = false;
            } else {
                System.out.println("Error please input again\n");
            }
        }
        System.out.print("What do you want to update? : ");
        String update = input.nextLine();
        try {
            Connection con = ConnectionBuild.getConnection();
            String sql = "UPDATE BUILDING SET " + where + "= '" + update + "' WHERE B_ID = " + id;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Update2 Error");
        }
        System.out.println("FINISH");
    }

    public static Building showDetailBuild(int id) {
        Building building = null;
        try {
            Connection con = ConnectionBuild.getConnection();
            String sql = "SELECT * FROM BUILDING WHERE B_ID =" + id;
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                building = new Building();
                getBuilding(rs, building);
            }
        } catch (Exception e) {
            System.out.println("ShowDetail Error");
        }
        return building;
    }

    public static Building showDetailBuild(String name) {
        Building building = null;
        try {
            Connection con = ConnectionBuild.getConnection();
            String sql = "SELECT * FROM BUILDING WHERE B_NAME =" + "'"+name+"'";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                building = new Building();
                getBuilding(rs, building);
            }
        } catch (Exception e) {
            System.out.println("ShowDetail Error");
        }
        return building;
    }

    public int getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(int buildingID) {
        this.buildingID = buildingID;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Building name : " + name + "\nPhone : " + phone + "\nEmail : " + email + "\nDescription : " + desc;
    }
}
