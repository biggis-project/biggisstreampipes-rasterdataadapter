package org.streampipes.biggis.pe.rasterdata.sources.tpimages;

import org.streampipes.model.SpDataStream;
import org.streampipes.model.graph.DataSourceDescription;
import org.streampipes.sdk.helpers.Labels;
import org.streampipes.vocabulary.Geo;
import org.streampipes.sdk.builder.DataStreamBuilder;
import org.streampipes.sdk.helpers.EpProperties;
import org.streampipes.sdk.helpers.Formats;
import org.streampipes.sdk.helpers.Protocols;
import org.streampipes.sources.AbstractAlreadyExistingStream;

/**
 * Created by Jochen Lutz on 2017-09-14.
 */
public class tpRestartableOobStream extends AbstractAlreadyExistingStream {

    @Override
    public SpDataStream declareModel(DataSourceDescription sepDescription) {
        return DataStreamBuilder.create("tpimages-stream-restartable-oob", "Technologiepark Raster data stream (restartable, out-of-band)", "This generates an oob stream of aerial pictures of TPK")
                .property(EpProperties.doubleEp(Labels.empty(), "latitude", Geo.lat))
                .property(EpProperties.doubleEp(Labels.empty(), "longitude", Geo.lng))
                .property(EpProperties.doubleEp(Labels.empty(), "altitude", Geo.alt))
                .property(EpProperties.stringEp(Labels.empty(), "filename", "http://types.streampipes.org/Filename"))
                .property(EpProperties.stringEp(Labels.empty(), "raster-data-location", "http://types.streampipes.org/RasterDataLocation"))
                .format(Formats.jsonFormat())
                .protocol(Protocols.kafka(tpImagesConfig.INSTANCE.getKafkaHost(), tpImagesConfig.INSTANCE.getKafkaPort(),
                        "org.streampipes.biggis.rasterdata.demo-source.oob"))
                .build();
    }
}
