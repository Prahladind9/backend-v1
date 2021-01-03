package edu.prahlad.dp.cdp.abstractfactory.gcp;

import edu.prahlad.dp.cdp.abstractfactory.Instance;
import edu.prahlad.dp.cdp.abstractfactory.ResourceFactory;
import edu.prahlad.dp.cdp.abstractfactory.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {

    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new GoogleComputeEngineInstance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new GoogleCloudStorage(capMib);
    }
}

