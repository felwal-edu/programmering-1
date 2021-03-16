package Övrigt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VerktygslådaTest {

    @Test
    void slumpaGemenZ() {

        // given
        Verktygslåda klass = new Verktygslåda();

        // when
        char stickprov = klass.slumpaGemen(1, "abcdefghijklmnopqrstuvwxy", true)[0];

        // then
        Assertions.assertEquals('z', stickprov);

    }

}