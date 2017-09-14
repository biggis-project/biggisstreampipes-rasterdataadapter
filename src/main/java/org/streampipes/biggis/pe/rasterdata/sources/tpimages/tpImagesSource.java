package org.streampipes.biggis.pe.rasterdata.sources.tpimages;

import org.streampipes.container.declarer.EventStreamDeclarer;
import org.streampipes.container.declarer.SemanticEventProducerDeclarer;
import org.streampipes.model.impl.graph.SepDescription;
import org.streampipes.sdk.builder.DataSourceBuilder;

import java.util.Arrays;
import java.util.List;

public class tpImagesSource implements SemanticEventProducerDeclarer {
    @Override
    public SepDescription declareModel() {
        return DataSourceBuilder.create("raster-data-source", "Raster data Demo Source", "This source generates raster data streams")
                .build();
    }

    @Override
    public List<EventStreamDeclarer> getEventStreams() {
        return Arrays.asList(new tpEndlessGeotiffStream(),
                new tpRestartableInlineStream(),
                new tpRestartableOobStream());
    }

}
