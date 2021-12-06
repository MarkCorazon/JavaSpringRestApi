package com.markcorazon.animals.controllers;

import com.markcorazon.animals.database.DatabaseConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
    @GetMapping
    public ResponseEntity sayHello() throws SQLException {
//        DatabaseConfig connection = new DatabaseConfig();
//        Connection conn = connection.getConn();
//        try {
//            Statement stmt = conn.createStatement();
//
//            if (stmt.execute("SELECT name FROM owners")) {
//                ResultSet rs = stmt.getResultSet();
//                return ResponseEntity.ok(rs);
//            } else {
//                //erreur
//                return ResponseEntity.notFound().build();
//            }
//        } catch (SQLException ex){
//            // handle any errors
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
//        }
//        return ResponseEntity.internalServerError().build();
        return ResponseEntity.ok().build();
    }
}
