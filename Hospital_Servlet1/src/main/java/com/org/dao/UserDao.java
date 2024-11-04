package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.entity.User;
import com.org.helper.ConnectionHelper;

public class UserDao {

    public boolean registerUser(User u, String[] errorMsg) {
        boolean isSuccess = false; // Default to failure
        try (Connection con = ConnectionHelper.getConObj();
             PreparedStatement ps = con.prepareStatement("INSERT INTO user(fullname, email, password, age, gender, phno) VALUES(?, ?, ?, ?, ?, ?)")) {
            
            ps.setString(1, u.getFullname());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setInt(4, u.getAge());
            ps.setString(5, u.getGender());
            ps.setString(6, u.getPhno());
            
            int res = ps.executeUpdate();
            if (res == 1) {
                isSuccess = true; // Registration successful
            } else {
                errorMsg[0] = "Registration failed. No rows affected.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorMsg[0] = "Database error: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            errorMsg[0] = "An unexpected error occurred: " + e.getMessage();
        }
        return isSuccess;
    }

    public User login(String email, String password) {
        User u = null;
        try (Connection con = ConnectionHelper.getConObj();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?")) {
            
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setFullname(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setAge(rs.getInt(5));
                u.setGender(rs.getString(6));
                u.setPhno(rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public boolean checkOldPassword(int userid, String oldPassword) {
        boolean isMatch = false;
        try (Connection con = ConnectionHelper.getConObj();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE id = ? AND password = ?")) {
            
            ps.setInt(1, userid);
            ps.setString(2, oldPassword);
            ResultSet rs = ps.executeQuery();
            isMatch = rs.next(); // If there's a result, the old password matches
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isMatch;
    }

    public boolean changePassword(int userid, String newPassword, String[] errorMsg) {
        boolean isSuccess = false; // Default to failure
        try (Connection con = ConnectionHelper.getConObj();
             PreparedStatement ps = con.prepareStatement("UPDATE user SET password = ? WHERE id = ?")) {
            
            ps.setString(1, newPassword);
            ps.setInt(2, userid);
            int i = ps.executeUpdate();
            if (i == 1) {
                isSuccess = true; // Password change successful
            } else {
                errorMsg[0] = "Password change failed. No rows affected.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorMsg[0] = "Database error: " + e.getMessage();
        } catch (Exception e) {
            errorMsg[0] = "An unexpected error occurred: " + e.getMessage();
        }
        return isSuccess;
    }

    // New method to retrieve all users
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection con = ConnectionHelper.getConObj();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM user")) {
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setPhno(rs.getString("phno"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
