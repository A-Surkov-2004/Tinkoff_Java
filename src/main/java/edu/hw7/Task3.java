package edu.hw7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class Task3 {

    private final ReadWriteLock readWriteLock
        = new ReentrantReadWriteLock();
    private final Lock writeLock
        = readWriteLock.writeLock();

    private final Lock readLock = readWriteLock.readLock();

    public Task3() {

    }

    public record Person(int id, String name, String address, String phoneNumber) {
    }

    public interface PersonDatabase {

        void add(Person person);

        void delete(int id);

        List<Person> findByName(String name);

        List<Person> findByAddress(String address);

        List<Person> findByPhone(String phone);
    }

    public class Database implements PersonDatabase {

        Database() {
        }

        Map<Integer, Person> persons = new HashMap<>();

        @Override
        public void add(Person person) {
            writeLock.lock();
            try {
                persons.put(person.id, person);
            } finally {
                writeLock.unlock();
            }
        }

        @Override
        public void delete(int id) {
            writeLock.lock();
            try {
                persons.remove(id);
            } finally {
                writeLock.unlock();
            }
        }

        @Override
        public List<Person> findByName(String name) {
            List<Person> ans;
            readLock.lock();
            try {

                ans = persons.values().stream()
                    .filter(person -> Objects.equals(person.name, name))
                    .collect(Collectors.toList());
            } finally {
                readLock.unlock();
            }
            return ans;
        }

        @Override
        public List<Person> findByAddress(String address) {
            List<Person> ans;
            readLock.lock();
            try {
                ans = persons.values().stream()
                    .filter(person -> Objects.equals(person.address, address))
                    .collect(Collectors.toList());
            } finally {
                readLock.unlock();
            }
            return ans;
        }

        @Override
        public List<Person> findByPhone(String phone) {
            List<Person> ans;
            readLock.lock();
            try {
                ans = persons.values().stream()
                    .filter(person -> Objects.equals(person.phoneNumber, phone))
                    .collect(Collectors.toList());
            } finally {
                readLock.unlock();
            }
            return ans;
        }
    }
}
