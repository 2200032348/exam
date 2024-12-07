package com.klef.jfsd.exam.labexam;

import jakarta.persistence.*;
import java.util.List;

public class ClientDemo {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("labexam");

    public static void main(String[] args) {
        insertClient("John Doe", "Male", 30, "New York", "john.doe@example.com", "9876543210");
        insertClient("Jane Smith", "Female", 28, "Los Angeles", "jane.smith@example.com", "8765432109");

        printAllClients();
    }

    public static void insertClient(String name, String gender, int age, String location, String email, String mobile) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Client client = new Client();
            client.setName(name);
            client.setGender(gender);
            client.setAge(age);
            client.setLocation(location);
            client.setEmail(email);
            client.setMobileNumber(mobile);

            em.persist(client);
            transaction.commit();

            System.out.println("Client inserted successfully: " + client);
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.out.println("Error inserting client: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public static void printAllClients() {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
            List<Client> clients = query.getResultList();

            System.out.println("All Clients:");
            for (Client client : clients) {
                System.out.println(client);
            }
        } catch (Exception e) {
            System.out.println("Error fetching clients: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
