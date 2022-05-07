package com.tasks;

import com.Utis.Gruppyi;
import com.Utis.Studentyi;
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

    public void updateGruppyi(int year) {
        Transaction t = session.beginTransaction();
        LocalDate date = LocalDate.now().minusYears(year);
        List<Gruppyi> q = session.createQuery("from Gruppyi g where g.dataFormir <'" + date + "'").list();
        List<Studentyi> q2 = session.createQuery("from Studentyi s").list();

        for (Gruppyi g : q) {
            g.setStatus("rasformirovana");
            g.setStatusDate(new Date());
            for (Studentyi s : q2) {
                if (s.getGruppyi().getShifr().equals(g.getShifr())) {
                    s.setStatus("vyipusknik");
                    s.setStatusDate(new Date());
                }
            }
            session.update(g);
        }
        t.commit();
    }
}
