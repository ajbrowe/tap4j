/*
 * The MIT License
 *
 * Copyright (c) 2010 tap4j team (see AUTHORS)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.tap4j.representer;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.tap4j.producer.TapProducerFactory;

/**
 * Tests for TAP Producer Factory.
 */
public class TestTapProducerFactory {

    @Test
    public void testTap13Producer() {
        assertNotNull(TapProducerFactory.makeTap13Producer());
    }
    
    @Test
    public void testTapJUnitProducer() {
        assertNotNull(TapProducerFactory.makeTapJunitProducer("any-name"));
    }
    
    @Test(expected=Throwable.class)
    public void testPrivateConstructor() throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        final Constructor<?> c = TapProducerFactory.class
                .getDeclaredConstructors()[0];
        c.setAccessible(true);
        final Object o = c.newInstance((Object[]) null);
        assertNotNull(o);
    }
    
}
