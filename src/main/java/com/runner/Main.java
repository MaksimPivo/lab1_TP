package com.runner;

import com.Utis.Gruppyi;
import com.Utis.NewHibernateUtil;
import com.Utis.Studentyi;
import com.tasks.Task1;
import com.tasks.Task2;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        Task2 task2 = new Task2(s);
        task2.updateGruppyi();

        s.close();
    }

}
