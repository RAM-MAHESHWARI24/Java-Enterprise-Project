package com.org.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "A@34e678";

    private static boolean isInitialized = false; // Flag to ensure initialization runs only once

    public static Connection getConObj() {
        Connection con = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            if (!isInitialized) {
                createDatabaseAndTables(con);
                isInitialized = true; // Set the flag to true after initialization
            }
            Statement stmt = con.createStatement();
            stmt.executeUpdate("USE hospital");

        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for more detail
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    private static void createDatabaseAndTables(Connection con) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            // Check if the 'hospital' database exists, if not, create it
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS hospital");

            // Use the 'hospital' database
            stmt.executeUpdate("USE hospital");

            // Create the 'user' table if it does not exist
            String createUserTable = "CREATE TABLE IF NOT EXISTS user (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "fullname VARCHAR(100) NOT NULL, " +
                    "email VARCHAR(100) NOT NULL UNIQUE, " +
                    "password VARCHAR(255) NOT NULL, " +
                    "age INT NOT NULL, " +                // Add age column
                    "phno VARCHAR(15) NOT NULL, " +       // Add phno column
                    "gender VARCHAR(10) NOT NULL" +        // Add gender column
                    ");";
            stmt.executeUpdate(createUserTable);

            // Create the 'doctor' table if it does not exist
            String createDoctorTable = "CREATE TABLE IF NOT EXISTS doctor (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "full_name VARCHAR(255) NOT NULL, " +
                    "dob DATE NOT NULL, " + // Added dob column
                    "qualification VARCHAR(255) NOT NULL, " + // Added qualification column
                    "specialist VARCHAR(255), " +
                    "email VARCHAR(255) UNIQUE NOT NULL, " +
                    "mobno VARCHAR(15) NOT NULL, " +
                    "password VARCHAR(255) NOT NULL" +
                    ");";
            stmt.executeUpdate(createDoctorTable);

            // Create the 'specialist' table if it does not exist
            String createSpecialistTable = "CREATE TABLE IF NOT EXISTS specialist (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "spec_name VARCHAR(255) NOT NULL UNIQUE" +
                    ");";
            stmt.executeUpdate(createSpecialistTable);

            // Create the 'appointment' table if it does not exist
            String createAppointmentTable = "CREATE TABLE IF NOT EXISTS appointment (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "user_id INT NOT NULL, " +
                    "fullname VARCHAR(100) NOT NULL, " +
                    "gender VARCHAR(10) NOT NULL, " +
                    "age INT NOT NULL, " +  // Changed to INT to match the age data type
                    "appoint_data DATE NOT NULL, " +
                    "email VARCHAR(100) NOT NULL, " +
                    "phno VARCHAR(15) NOT NULL, " +
                    "disease VARCHAR(255), " +
                    "doctor_id INT NOT NULL, " +
                    "status VARCHAR(20) NOT NULL, " +
                    "FOREIGN KEY (user_id) REFERENCES user(id), " +
                    "FOREIGN KEY (doctor_id) REFERENCES doctor(id)" +
                    ");";
            stmt.executeUpdate(createAppointmentTable);

            // Insert hardcoded specialists
            insertSpecialists(stmt);

            // Insert hardcoded doctors
            insertDoctors(stmt);

            // Insert hardcoded patients
            insertPatients(stmt);

            // Insert hardcoded appointments
            insertAppointments(stmt);

        } catch (SQLException e) {
            System.err.println("SQL Exception during database/table creation: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for detailed error
        } finally {
            // Close the statement
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void insertSpecialists(Statement stmt) throws SQLException {
        String[] specialists = {
            "INSERT INTO specialist (spec_name) VALUES " +
            "('Cardiology'), " +
            "('Dermatology'), " +
            "('Neurology'), " +
            "('Pediatrics'), " +
            "('General Medicine');"
        };

        for (String specialist : specialists) {
            stmt.executeUpdate(specialist);
        }
    }

    private static void insertDoctors(Statement stmt) throws SQLException {
        String[] doctors = {
            "INSERT INTO doctor (full_name, dob, qualification, specialist, email, mobno, password) VALUES " + // Updated to match all columns
            "('Dr. Rajesh Sharma', '1980-01-01', 'MBBS', 'Cardiology', 'd1@gmail.com', '9999999990', '123'), " +
            "('Dr. Priya Desai', '1985-02-02', 'MD', 'Dermatology', 'd2@gmail.com', '9999999991', '123'), " +
            "('Dr. Amit Verma', '1990-03-03', 'DM', 'Neurology', 'd3@gmail.com', '9999999992', '123'), " +
            "('Dr. Neha Gupta', '1988-04-04', 'MBBS', 'Pediatrics', 'd4@gmail.com', '9999999993', '123'), " +
            "('Dr. Anil Singh', '1975-05-05', 'MBBS', 'General Medicine', 'd5@gmail.com', '9999999994', '123');"
        };

        for (String doctor : doctors) {
            stmt.executeUpdate(doctor);
        }
    }

    private static void insertPatients(Statement stmt) throws SQLException {
        String[] patients = {
            "INSERT INTO user (fullname, email, password, age, phno, gender) VALUES " +
            "('Aarav Mehta', 'p1@gmail.com', '123', 25, '9999999991', 'Male'), " +
            "('Saanvi Verma', 'p2@gmail.com', '123', 30, '9999999991', 'Female'), " +
            "('Riya Sharma', 'p3@gmail.com', '123', 28, '9999999991', 'Female');"
        };

        for (String patient : patients) {
            stmt.executeUpdate(patient);
        }
    }

    private static void insertAppointments(Statement stmt) throws SQLException {
        String[] appointments = {
            // Assuming today's date is 2024-11-04 for demonstration purposes
            "INSERT INTO appointment (user_id, fullname, gender, age, appoint_data, email, phno, disease, doctor_id, status) VALUES " +
            "(1, 'Aarav Mehta', 'Male', 25, '2024-11-04', 'p1@gmail.com', '9999999991', 'Heart Issues', 1, 'Pending'), " +  // Appointment with Cardiologist
            "(1, 'Aarav Mehta', 'Male', 25, '2024-11-04', 'p1@gmail.com', '9999999991', 'Skin Rashes', 2, 'Pending'), " +   // Appointment with Dermatologist
            "(2, 'Saanvi Verma', 'Female', 30, '2024-11-04', 'p2@gmail.com', '8888888888', 'Eczema', 2, 'Pending'), " +      // Appointment with Dermatologist
            "(3, 'Riya Sharma', 'Female', 28, '2024-11-04', 'p3@gmail.com', '7777777777', 'Migraine', 3, 'Pending'), " +     // Appointment with Neurologist
            "(3, 'Riya Sharma', 'Female', 28, '2024-11-04', 'p3@gmail.com', '7777777777', 'Regular Checkup', 5, 'Pending');"  // Appointment with General Practitioner
        };

        for (String appointment : appointments) {
            stmt.executeUpdate(appointment);
        }
    }

//    public static void resetInitialization() {
//        isInitialized = false; // Reset the initialization flag
//    }
}
