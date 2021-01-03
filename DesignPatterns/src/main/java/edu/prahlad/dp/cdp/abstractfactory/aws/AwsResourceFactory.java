package edu.prahlad.dp.cdp.abstractfactory.aws;

import edu.prahlad.dp.cdp.abstractfactory.Instance;
import edu.prahlad.dp.cdp.abstractfactory.ResourceFactory;
import edu.prahlad.dp.cdp.abstractfactory.Storage;

//Factory implementation for Google cloud platform resources
public class AwsResourceFactory implements ResourceFactory {


    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new Ec2Instance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new S3Storage(capMib);
    }
}
