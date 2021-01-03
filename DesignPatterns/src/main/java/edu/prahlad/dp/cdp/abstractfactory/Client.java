package edu.prahlad.dp.cdp.abstractfactory;

import edu.prahlad.dp.cdp.abstractfactory.aws.AwsResourceFactory;
import edu.prahlad.dp.cdp.abstractfactory.gcp.GoogleResourceFactory;

public class Client {

    private ResourceFactory resourceFactory;

    public Client(ResourceFactory resourceFactory){
        this.resourceFactory = resourceFactory;
    }

    public Instance createServer(Instance.Capacity cap, int storageMib){
        Instance instance = resourceFactory.createInstance(cap);
        Storage storage = resourceFactory.createStorage(storageMib);
        instance.attachStorage(storage);

        return instance;
    }

    public static void main(String[] args) {
        Client aws = new Client(new AwsResourceFactory());
        Instance i1 = aws.createServer(Instance.Capacity.micro, 20480);
        i1.start();
        i1.stop();

        System.out.println("************");

        Client gcp = new Client(new GoogleResourceFactory());
        i1 = gcp.createServer(Instance.Capacity.micro, 20480);
        i1.start();
        i1.stop();

    }
}
