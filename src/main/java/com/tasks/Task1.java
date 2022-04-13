package com.tasks;

import com.Utis.Studentyi;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    private final Session session;

    public Task1(Session session) {
        this.session = session;
    }

    public void slectStudentyi() {
        Transaction t1 = session.beginTransaction();
        List<Studentyi> q = session.createQuery("from Studentyi s").list();
        for (Studentyi u : q) {
            System.out.print(u.getFamiliya() + " " + u.getImya() + " " + u.getOtchestvo() + " - " + u.getGruppyi().getNazvanie() + ";\n");
            u.setStatusDate(new Date());
            session.saveOrUpdate(u);
        }
        t1.commit();
    }

    public void amountStudentyiInGruppyi() {
        Transaction t2 = session.beginTransaction();
        List<Studentyi> st = session.createQuery("from Studentyi s").list();
        st.stream().collect(Collectors.groupingBy(Studentyi::getGruppyi)).forEach((a, b) -> System.out.println(a.getNazvanie() + " - " + b.stream().count()));
        t2.commit();
    }
}
