package ru.bank;

import ru.bank.Account;
import ru.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс, представляющий собой сервис банка, который управляет пользователями и их аккаунтами.
 * @author NAZARYCHEVA ANASTASIA
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей осуществляется в коллекции типа Map,
     * где ключом является объект User, а значением список аккаунтов (Account),
     * принаджлежащих данному пользователю.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход нового пользователя и добавляет его в коллекцию.
     * Если пользователь с таким паспортом уже существует, то он не будет добавлен.
     * @param user пользователь который добавляется в коллекцию
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспорт по которому нужно удалить пользователя из коллекции.
     * @param passport паспорт пользователя, которого нужно удалить.
     */
    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
        }
    }

    /**
     * Метод добавляет новый аккаунт для пользователя, если такой аккаунт ещё не существует.
     * @param passport паспорт пользователя, которому добавляется аккаунт.
     * @param account новый аккаунт который нужно добавить.
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту и возвращает его.
     * Если пользователь с указанным паспортом не найден, возвращает null.
     * @param passport паспорт пользователя, которого нужно найти
     * @return найденный пользоваетль или null, если пользоваетль не найден.
     */

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет аккаунт по паспорту пользователя и реквизиту аккаунта.
     * Если аккаунт найден, возвращает его;
     * если нет - возвращает null.
     * @param passport паспорт пользователя, которому принадлежит аккаунт
     * @param requisite реквизит аккаунта, который нужно найти
     * @return найденный аккаунт или null, если аккаунт не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }
    /**
     * Метод осуществляет перевод денег с одного аккаунта на другой.
     * Проверяет наличие необходимых условий: существование обоих аккаунтов и достаточный баланс.
     *
     * @param sourcePassport паспорт источника перевода
     * @param sourceRequisite реквизит источника перевода
     * @param destinationPassport паспорт получателя перевода
     * @param destinationRequisite реквизит получателя перевода
     * @param amount сумма перевода
     * @return true, если перевод успешен; false в противном случае
     */

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account distinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && distinationAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.withdraw(amount);
            distinationAccount.deposit(amount);
            return true;
        }
        return false;
    }
    /**
     * Метод возвращает список аккаунтов, принадлежащих указанному пользователю.
     * @param user пользователь, для которого требуется получить список аккаунтов
     * @return список аккаунтов данного пользователя или null, если пользователь не найден
     */

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
