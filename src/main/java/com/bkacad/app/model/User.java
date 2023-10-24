package com.bkacad.app.model;

/**
 * User
 */
public class User {
    public enum UserRole {
        ADMIN,
        SALE,
        WAREHOUSE
    }
    public String username;
    public String password;
    public UserRole role;

    public User(String u, String p, UserRole r){
        this.username = u;
        this.password = p;
        this.role = r;
    }
    public User(String u, String p, String r){
        this.username = u;
        this.password = p;
        switch (r){
            case "A":
                this.role=UserRole.ADMIN;
                break;
            case "S":
                this.role=UserRole.SALE;
                break;
            case "W":
                this.role=UserRole.WAREHOUSE;
                break;
            default:
                this.role=UserRole.ADMIN;
        }
    }

    public String getRole(){
        switch (this.role){
            case ADMIN:
                return "A";
            case SALE:
                return "S";
            case WAREHOUSE:
                return "W";
            default:
                return "W";
        }
    }
}