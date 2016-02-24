package com.barracuda.rtdict.dao.impl;

import com.barracuda.rtdict.dao.WordDAO;
import com.barracuda.rtdict.dao.hiber_util.HibernateUtil;
import com.barracuda.rtdict.yandex.translate.parser.word.gson.Def;
import com.barracuda.rtdict.yandex.translate.parser.word.gson.Ex;
import com.barracuda.rtdict.yandex.translate.parser.word.gson.Mean;
import com.barracuda.rtdict.yandex.translate.parser.word.gson.Syn;
import com.barracuda.rtdict.yandex.translate.parser.word.gson.Tr;
import com.barracuda.rtdict.yandex.translate.parser.word.gson.TrSecond;
import com.barracuda.rtdict.yandex.translate.parser.word.gson.Word;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author RT
 */
public class WordDaoImplH2 implements WordDAO{

//    .addAnnotatedClass(Word.class)
//                        .addAnnotatedClass(Def.class)
//                        .addAnnotatedClass(Tr.class)
//                        .addAnnotatedClass(Syn.class)
//                        .addAnnotatedClass(Mean.class)
//                        .addAnnotatedClass(Ex.class)
//                        .addAnnotatedClass(TrSecond.class);
    
    @Override
    public void add(Word word) throws SQLException {
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.save(word);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Word word) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Word getById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Word word) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
