package edu.prahlad.dp.cdp.singleton;

public class Client {
    public static void main(String[] args) {
//        singletonCall();

        LazyRegistryIODH singleton;
        singleton = LazyRegistryIODH.getInstance();
        singleton = LazyRegistryIODH.getInstance();
        singleton = LazyRegistryIODH.getInstance();
        System.out.println("Done");

    }

    private static void singletonCall() {
        EagerRegistry registry = EagerRegistry.getInstance();
        EagerRegistry registry2 = EagerRegistry.getInstance();
        //Reference are same - singleton
        System.out.println(registry == registry2);

        LazyRegistryWithDCL lazyRegistryWithDCL = LazyRegistryWithDCL.getInstance();
        LazyRegistryWithDCL lazyRegistryWithDCL2 = LazyRegistryWithDCL.getInstance();
        System.out.println(lazyRegistryWithDCL == lazyRegistryWithDCL2);
    }
}
