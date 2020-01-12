package com.dopatraman.arbitrary;

import java.lang.reflect.Type;

public interface ArbitraryTypeConstructor {
    <T extends Object> T constructArbitrary();
}
