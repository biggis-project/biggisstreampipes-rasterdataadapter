package org.streampipes.biggis.pe.rasterdata.sources.tpimages;

import org.streampipes.model.impl.EventStream;
import org.streampipes.model.impl.graph.SepDescription;
import org.streampipes.model.vocabulary.Geo;
import org.streampipes.sdk.builder.DataStreamBuilder;
import org.streampipes.sdk.helpers.EpProperties;
import org.streampipes.sdk.helpers.Formats;
import org.streampipes.sdk.helpers.Protocols;
import org.streampipes.sources.AbstractAlreadyExistingStream;

public class tpImagesStream extends AbstractAlreadyExistingStream {

    @Override
    public EventStream declareModel(SepDescription sepDescription) {
        return DataStreamBuilder.create("tpimages-stream", "Technologiepark Raster data stream", "This stream generates aerial pictures of TPK")
                .property(EpProperties.doubleEp("latitude", Geo.lat))
                .property(EpProperties.doubleEp("longitude", Geo.lng))
                .property(EpProperties.doubleEp("altitude", Geo.alt))
                .property(EpProperties.stringEp("raster-data", "http://types.streampipes.org/RasterData"))
                .format(Formats.thriftFormat())
                .protocol(Protocols.kafka(tpImagesConfig.INSTANCE.getKafkaHost(), tpImagesConfig.INSTANCE.getKafkaPort(),
                        "org.streampipes.biggis.rasterdata.demo-source-endless-geotiff"))
                .build();
    }
}
