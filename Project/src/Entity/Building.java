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
