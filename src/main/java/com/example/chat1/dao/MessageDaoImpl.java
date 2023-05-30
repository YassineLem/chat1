package com.example.chat1.dao;


import java.util.List;
import com.example.chat1.metier.Message;
import com.example.chat1.metier.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Transactional
public class MessageDaoImpl implements MessageDao {
    @PersistenceContext
    private EntityManagerFactory entityManagerFactory;

    public MessageDaoImpl() {
        entityManagerFactory =Persistence.createEntityManagerFactory("default");
    }

    @Override
    public Message getMessageById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Message.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Message> getAllMessages() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT u FROM Message u", Message.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void addMessage(Message message) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(message);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void updateMessage(Message message) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(message);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteMessage(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Message message = entityManager.find(Message.class, id);
            if (message != null) {
                entityManager.remove(message);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}

