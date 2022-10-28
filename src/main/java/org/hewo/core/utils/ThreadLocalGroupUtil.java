package org.hewo.core.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class ThreadLocalGroupUtil {

    private static final Logger log = LoggerFactory.getLogger( ThreadLocalGroupUtil.class );
    private static final ThreadLocal<Map<Object, Object>> resources = new InheritableThreadLocalMap<Map<Object, Object>>();

    protected ThreadLocalGroupUtil() {}

    public static Map<Object, Object> getResources() {
        return resources != null ? new HashMap<Object, Object>( resources.get() ) : null;
    }

    public static void setResources( Map<Object, Object> newResources ) {
        if ( newResources == null || newResources.isEmpty() ) {
            return;
        }
        resources.get().clear();
        resources.get().putAll( newResources );
    }

    private static Object getValue( Object key ) {
        return resources.get().get( key );
    }


    public static Object get( Object key ) {
        if ( log.isTraceEnabled() ) {
            String msg = "get() - in thread [" + Thread.currentThread().getName() + "]";
            log.trace( msg );
        }

        Object value = getValue( key );
        if ( ( value != null ) && log.isTraceEnabled() ) {
            String msg = "Retrieved value of type [" + value.getClass().getName() + "] for key [" + key + "] " + "bound to thread [" + Thread.currentThread().getName() + "]";
            log.trace( msg );
        }
        return value;
    }

    public static void put( Object key, Object value ) {
        if ( key == null ) {
            throw new IllegalArgumentException( "key cannot be null" );
        }

        if ( value == null ) {
            remove( key );
            return;
        }

        resources.get().put( key, value );

        if ( log.isTraceEnabled() ) {
            String msg = "Bound value of type [" + value.getClass().getName() + "] for key [" + key + "] to thread " + "[" + Thread.currentThread().getName() + "]";
            log.trace( msg );
        }
    }

    public static Object remove( Object key ) {
        Object value = resources.get().remove( key );

        if ( ( value != null ) && log.isTraceEnabled() ) {
            String msg = "Removed value of type [" + value.getClass().getName() + "] for key [" + key + "]" + "from thread [" + Thread.currentThread().getName() + "]";
            log.trace( msg );
        }

        return value;
    }
    /**
     *
     * @Description: InheritableThreadLocal继承了ThreadLocal，此类扩展了ThreadLocal以提供从父线程到子线程的值的继承：
    当创建子线程时，子线程接收父线程具有的所有可继承线程局部变量的初始值。 通常子线程的值与父线程的值是一致的。 但是，通过重写此类中的childValue方法，可以将子线程的值作为父线程的任意函数。
     * @author PC0034
     *
     * @param
     */
    private static final class InheritableThreadLocalMap<T extends Map<Object, Object>> extends InheritableThreadLocal<Map<Object, Object>> {

        @Override
        protected Map<Object, Object> initialValue() {
            return new HashMap<Object, Object>();
        }

        @Override
        @SuppressWarnings( { "unchecked" } )
        protected Map<Object, Object> childValue( Map<Object, Object> parentValue ) {
            if ( parentValue != null ) {
                return (Map<Object, Object>) ( (HashMap<Object, Object>) parentValue ).clone();
            } else {
                return null;
            }
        }
    }

    public static void remove() {
        resources.remove();
    }
}

