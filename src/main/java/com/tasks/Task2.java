package com.tasks;

import com.Utis.Gruppyi;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Task2 {
    private final Session session;

    public Task2(Session session) {
        this.session = session;
    }

    public void updateGruppyi() {
        Transaction t1 = session.beginTransaction();
        int year = LocalDate.now().getYear();
        List<Gruppyi> q = session.createQuery("from Gruppyi g").list();

        for (Gruppyi g : q) {
            if (year - Integer.parseInt(g.getDataFormir().toString().split("-")[0]) >= 9) {
                g.setStatus("rasformirovana");
            }
            g.setStatusDate(new Date());
            session.update(g);
        }
        t1.commit();
    }
}
