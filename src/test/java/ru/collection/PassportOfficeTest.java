package ru.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenAddDuplicateUser() {
        Citizen citizen = new Citizen("2f44a", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        boolean addedFirst = office.add(citizen);
        assertThat(addedFirst).isTrue();
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
        Citizen duplicateCitizen = new Citizen("2f44a", "Platon Ivanov");
        boolean addedDuplicate = office.add(duplicateCitizen);
        assertThat(addedDuplicate).isFalse();
    }
}
