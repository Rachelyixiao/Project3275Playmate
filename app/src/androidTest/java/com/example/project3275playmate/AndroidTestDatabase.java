package com.example.project3275playmate;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import com.example.project3275playmate.Classes.User;
import com.example.project3275playmate.DAO.DAO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


public class AndroidTestDatabase {
    DAO dao;
    User user;

    @Test
    public void testInsert() throws SQLException, ClassNotFoundException {
        Context context = ApplicationProvider.getApplicationContext();
        dao = new DAO(context);
        user = new User("testInsert123", "testInsert1", "testInsert1");
        dao.addCustomer(user);
    }

    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {
        Context context = ApplicationProvider.getApplicationContext();
        dao = new DAO(context);
        user = new User("testNameDelete1", "testEmail1", "testPassword1");
        dao.addCustomer(user);
        dao.delete("testNameDelete1");
        assertEquals(dao.searchUser("testNameDelete1"), null);
    }

    @Test
    public void testSelect() throws SQLException, ClassNotFoundException{
        Context context = ApplicationProvider.getApplicationContext();
        dao = new DAO(context);
        assertEquals("Mary", dao.searchUser("Mary").getName());
    }

    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException{
        Context context = ApplicationProvider.getApplicationContext();
        dao = new DAO(context);
        user = new User("testUpdate", "testUpdate", "testUpdate");
        dao.edit(user, "testUpdate1");
        assertEquals(user.getName(), "testUpdate");
    }
}
