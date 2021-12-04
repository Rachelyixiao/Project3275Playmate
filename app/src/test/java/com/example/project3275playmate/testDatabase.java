package com.example.project3275playmate;

import android.app.Instrumentation;
import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import com.example.project3275playmate.Classes.User;
import com.example.project3275playmate.DAO.DAO;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.robolectric.RobolectricTestRunner;

import java.sql.SQLException;


public class testDatabase {
    DAO dao;
    User user;

    @BeforeEach
    public void testInit(){

    }

    @Test
    public void testInsert() throws SQLException, ClassNotFoundException {
        Context context = ApplicationProvider.getApplicationContext();
        dao = new DAO(context);
        user = new User("testName1", "testEmail1", "testPassword1");
        dao.addCustomer(user);
    }

    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {
        Context context = ApplicationProvider.getApplicationContext();
        dao = new DAO(context);
        user = new User("testName1", "testEmail1", "testPassword1");
        dao.delete(user.getName());
    }

    @Test
    public void testSelect() throws SQLException, ClassNotFoundException{
        Context context = ApplicationProvider.getApplicationContext();
        dao = new DAO(context);
        user = new User("testName1", "testEmail1", "testPassword1");
        dao.searchUser(user.getName());
    }

    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException{
        Context context = ApplicationProvider.getApplicationContext();
        dao = new DAO(context);
        user = new User("testName1", "testEmail1", "testPassword1");
        dao.edit(user, "testName2");
    }
}
