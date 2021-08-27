package persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectDBTest {

    @Test
    void isConnect() {
        ConnectDB connect = new ConnectDB();
        assertTrue( connect.isConnect());
    }
}