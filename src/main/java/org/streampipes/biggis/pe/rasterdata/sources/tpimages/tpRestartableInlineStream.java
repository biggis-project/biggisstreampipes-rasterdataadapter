package org.streampipes.biggis.pe.rasterdata.sources.tpimages;

import org.streampipes.model.impl.EventStream;
import org.streampipes.model.impl.graph.SepDescription;
import org.streampipes.model.vocabulary.Geo;
import org.streampipes.sdk.builder.DataStreamBuilder;
import org.streampipes.sdk.helpers.EpProperties;
import org.streampipes.sdk.helpers.Formats;
import org.streampipes.sdk.helpers.Protocols;
import org.streampipes.sources.AbstractAlreadyExistingStream;

/**
 * Created by Jochen Lutz on 2017-09-14.
 */
public class tpRestartableInlineStream extends AbstractAlreadyExistingStream {

    @Override
    public EventStream declareModel(SepDescription sepDescription) {
        return DataStreamBuilder.create("tpimages-stream-restartable-inline", "Technologiepark Raster data stream", "This generates an inline stream of aerial pictures of TPK")
                .property(EpProperties.doubleEp("latitude", Geo.lat))
                .property(EpProperties.doubleEp("longitude", Geo.lng))
                .property(EpProperties.doubleEp("altitude", Geo.alt))
                .property(EpProperties.stringEp("raster-data", "http://types.streampipes.org/RasterData"))
                .format(Formats.jsonFormat())
                .protocol(Protocols.kafka(tpImagesConfig.INSTANCE.getKafkaHost(), tpImagesConfig.INSTANCE.getKafkaPort(),
                        "org.streampipes.biggis.rasterdata.demo-source.inline"))
                .build();
    }
}
