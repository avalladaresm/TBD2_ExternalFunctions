package com.company;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ping("macys.com");
        bin2dec("11010101100101");
        dec2bin(20);
        c2f(50);
        f2c(10);
    }

    public static int ping(String servername){
        Connection sqlite_con = null;
        InetAddress inet = null;

        try {
            Class.forName("org.sqlite.JDBC");
            sqlite_con = DriverManager.getConnection("jdbc:sqlite:C:/Users/javal/IdeaProjects/DB_External_Functions\\sqlite_db");
            System.out.println("Connection successful");

            String localhost = "127.0.0.1";
            inet = InetAddress.getByName(localhost);
            System.out.println("Sending Ping Request to " + localhost);
            System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");

            inet = InetAddress.getByName(servername);
            System.out.println("Sending Ping Request to " + servername);
            System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
            return 1;

        }catch (Exception e) {
            System.out.println(e);
            return 0;
        }finally {
            return 0;
        }
    }


    public static void bin2dec(String bin){
        int dec = Integer.parseInt(bin, 2);
        System.out.println("El numero binario "+ bin +", en decimal es " + dec);
    }

    public static String dec2bin(int dec){
        if (dec == 0) {
            return "0"; // special case
        }

        final StringBuilder result = new StringBuilder();
        int current = dec;

        while (current != 0) {
            result.append(current & 0x1);
            current = current >> 1;
        }

        System.out.println("El numero decimal "+ dec +", en binario es " + result.reverse().toString());
        return result.reverse().toString();
    }

    public static void c2f(int c){
        int f = (c*9/5) + 32;
        System.out.println(c + " °C = " + f + " °F");
    }

    public static void f2c(int f){
        int c = (f-32) * 5/9;
        System.out.println(f + " °F = " + c + " °C");
    }

}
