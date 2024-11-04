package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.org.entity.Appointment;
import com.org.helper.ConnectionHelper;

public class AppointmentDao {

    private Connection con = ConnectionHelper.getConObj();

    public boolean addAppointment(Appointment a) {
        boolean f = false;

        try {
            String sql = "INSERT INTO appointment(user_id, fullname, gender, age, appoint_data, email, phno, disease, doctor_id, status) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getUserId());
            ps.setString(2, a.getFullName());
            ps.setString(3, a.getGender());
            ps.setString(4, a.getAge());
            ps.setString(5, a.getAppoinDate());
            ps.setString(6, a.getEmail());
            ps.setString(7, a.getPhNo());
            ps.setString(8, a.getDiseases());
            ps.setInt(9, a.getDoctorId());
            // Removed address
            ps.setString(10, a.getStatus());

            int res = ps.executeUpdate();
            if (res == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public List<Appointment> getAllAppointmentByLoginUser(int userId) {
        List<Appointment> list = new ArrayList<>();
        Appointment ap = null;

        try {
            String sql = "SELECT * FROM appointment WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ap = new Appointment();
                ap.setId(rs.getInt(1));
                ap.setUserId(rs.getInt(2));
                ap.setFullName(rs.getString(3));
                ap.setGender(rs.getString(4));
                ap.setAge(rs.getString(5));
                ap.setAppoinDate(rs.getString(6));
                ap.setEmail(rs.getString(7));
                ap.setPhNo(rs.getString(8));
                ap.setDiseases(rs.getString(9));
                ap.setDoctorId(rs.getInt(10));
                // Removed address
                ap.setStatus(rs.getString(11));
                list.add(ap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Appointment> getAllAppointmentByDoctorLogin(int doctorId) {
        List<Appointment> list = new ArrayList<>();
        Appointment ap = null;

        try {
            String sql = "SELECT * FROM appointment WHERE doctor_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ap = new Appointment();
                ap.setId(rs.getInt(1));
                ap.setUserId(rs.getInt(2));
                ap.setFullName(rs.getString(3));
                ap.setGender(rs.getString(4));
                ap.setAge(rs.getString(5));
                ap.setAppoinDate(rs.getString(6));
                ap.setEmail(rs.getString(7));
                ap.setPhNo(rs.getString(8));
                ap.setDiseases(rs.getString(9));
                ap.setDoctorId(rs.getInt(10));
                // Removed address
                ap.setStatus(rs.getString(11));
                list.add(ap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Appointment getAppointmentById(int id) {
        Appointment ap = null;

        try {
            String sql = "SELECT * FROM appointment WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ap = new Appointment();
                ap.setId(rs.getInt(1));
                ap.setUserId(rs.getInt(2));
                ap.setFullName(rs.getString(3));
                ap.setGender(rs.getString(4));
                ap.setAge(rs.getString(5));
                ap.setAppoinDate(rs.getString(6));
                ap.setEmail(rs.getString(7));
                ap.setPhNo(rs.getString(8));
                ap.setDiseases(rs.getString(9));
                ap.setDoctorId(rs.getInt(10));
                // Removed address
                ap.setStatus(rs.getString(11));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ap;
    }

    public boolean updateCommentStatus(int id, int doctId, String comm) {
        boolean f = false;
        try {
            String sql = "UPDATE appointment SET status=? WHERE id=? AND doctor_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, comm);
            ps.setInt(2, id);
            ps.setInt(3, doctId);

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public List<Appointment> getAllAppointment() {
        List<Appointment> list = new ArrayList<>();
        Appointment ap = null;

        try {
            String sql = "SELECT * FROM appointment ORDER BY id DESC";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ap = new Appointment();
                ap.setId(rs.getInt(1));
                ap.setUserId(rs.getInt(2));
                ap.setFullName(rs.getString(3));
                ap.setGender(rs.getString(4));
                ap.setAge(rs.getString(5));
                ap.setAppoinDate(rs.getString(6));
                ap.setEmail(rs.getString(7));
                ap.setPhNo(rs.getString(8));
                ap.setDiseases(rs.getString(9));
                ap.setDoctorId(rs.getInt(10));
                // Removed address
                ap.setStatus(rs.getString(11));
                list.add(ap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
