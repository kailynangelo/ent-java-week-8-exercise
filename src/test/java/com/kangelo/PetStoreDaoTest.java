package com.kangelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetStoreDaoTest {

    @Test
    void getPetSuccess() {

        PetStoreDao dao = new PetStoreDao();
        assertEquals("doggie", dao.getPet().getName());
    }
}