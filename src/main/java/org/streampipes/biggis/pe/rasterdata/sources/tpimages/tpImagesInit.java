package org.streampipes.biggis.pe.rasterdata.sources.tpimages;

import org.streampipes.container.init.DeclarersSingleton;
import org.streampipes.container.standalone.init.StandaloneModelSubmitter;

public class tpImagesInit extends StandaloneModelSubmitter {

    public static void main(String[] args) {
        DeclarersSingleton.getInstance()
                .add(new tpImagesSource());

        DeclarersSingleton.getInstance().setHostName(tpImagesConfig.INSTANCE.getHost());
        DeclarersSingleton.getInstance().setPort(tpImagesConfig.INSTANCE.getPort());
        new tpImagesInit().init();
    }
}
