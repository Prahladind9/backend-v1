package edu.prahlad.dp.cdp.singleton;

/**
 * Singleton pattern using lazy initialization holder class. This ensures that, we have a lazy initialization
 * without worrying about synchronization.
 *
 * alternative to LazyRegistryWithDCL - best way for lazy
 */
public class LazyRegistryIODH {

    private LazyRegistryIODH(){
        System.out.println("In LazyRegistryIODH singleton");

    }

    private static class RegistryHolder{
        static LazyRegistryIODH INSTANCE = new LazyRegistryIODH();
    }

    public static LazyRegistryIODH getInstance(){
        return RegistryHolder.INSTANCE;
    }
}