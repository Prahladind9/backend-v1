package edu.prahlad.dp.cdp.singleton;

/**
 * This class demonstrates singleton pattern using Double Checked Locking or "classic" singleton.
 * This is also a lazy initializing singleton.
 * Although this implementation solves the multi-threading issue with lazy initialization using volatile
 * and double check locking, the volatile keyword is guaranteed to work only after JVMs starting with
 * version 1.5 and later.
 */
public class LazyRegistryWithDCL {

    private LazyRegistryWithDCL(){
        System.out.println("In LazyRegistryWithDCL singleton");
    }

    //To avoid caching the INSTANCE value
    private static volatile LazyRegistryWithDCL INSTANCE;

    //Double check
    public static LazyRegistryWithDCL getInstance(){
        if(INSTANCE == null){
            //Lock on whole class
            synchronized (LazyRegistryWithDCL.class){
                if(INSTANCE == null){
                    INSTANCE = new LazyRegistryWithDCL();
                }
            }
        }
        return INSTANCE;
    }

}

