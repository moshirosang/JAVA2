/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import static Entity.Building.showDetailBuild;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Admin {
    private String username;
    private String password;
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
}
