package es.cuatrogatos.graphite.solax.boundary;

import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import es.cuatrogatos.graphite.solax.entity.SolaxMetrics;
import es.cuatrogatos.solax.boundary.SolaxClient;


import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class SolaxExporter {
    Logger logger=Logger.getLogger("SOLAX-EXPORTER");

    private boolean metricsInitialized=false;
    private long exportInterval=-1;

    private SolaxMetrics solaxMetrics;
    private SolaxClient solaxClient;

    MetricRegistry metricRegistry=null;

    public SolaxExporter(String tokenId,String serialNumber,long flushInterval) throws MalformedURLException, ExecutionException, InterruptedException {
        this.exportInterval=flushInterval;
        solaxClient=new SolaxClient("https://www.solaxcloud.com:9443/proxy/api/",tokenId,serialNumber);
        solaxMetrics=new SolaxMetrics(solaxClient);
        this.initializeMetrics();
    }

    public MetricRegistry initializeMetrics() throws ExecutionException, InterruptedException {
        if(!metricsInitialized){
            metricRegistry=new MetricRegistry();

            String prefix="solax."+solaxClient.queryEndpoint().getResult().getInverterSN();

            metricRegistry.register(prefix+"acpower",solaxMetrics.getAcPower());
            metricRegistry.register(prefix+"yieldtoday",solaxMetrics.getYieldToday());
            metricRegistry.register(prefix+"yieldtotal",solaxMetrics.getYieldTotal());
            metricRegistry.register(prefix+"feedinpower",solaxMetrics.getFeedinpower());
            metricRegistry.register(prefix+"feedinenergy",solaxMetrics.getFeedinenergy());
            metricRegistry.register(prefix+"consumeenergy",solaxMetrics.getConsumeenergy());
            metricRegistry.register(prefix+"feedinpowerM2",solaxMetrics.getFeedinpowerM2());
            metricRegistry.register(prefix+"soc",solaxMetrics.getSoc());
            metricRegistry.register(prefix+"peps1",solaxMetrics.getPeps1());
            metricRegistry.register(prefix+"peps2",solaxMetrics.getPeps2());
            metricRegistry.register(prefix+"peps3",solaxMetrics.getPeps3());
            metricRegistry.register(prefix+"inverterStatus",solaxMetrics.getInverterStatus());
            metricRegistry.register(prefix+"batPower",solaxMetrics.getBatPower());
            metricRegistry.register(prefix+"powerdc1",solaxMetrics.getPowerdc1());
            metricRegistry.register(prefix+"powerdc2",solaxMetrics.getPowerdc2());
            metricRegistry.register(prefix+"powerdc3",solaxMetrics.getPowerdc3());
            metricRegistry.register(prefix+"powerdc4",solaxMetrics.getPowerdc4());



            metricsInitialized=true;

        }

        return metricRegistry;
    }

    public void export(String hostname,int port,boolean dryRun){

        logger.warning("STARTING THE EXPORT ROUTINE TO SERVER "+hostname+":"+port);
        final Graphite graphite = new Graphite(new InetSocketAddress(hostname, port));
        final GraphiteReporter remoteReporter = GraphiteReporter.forRegistry(metricRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .filter(MetricFilter.ALL)
                .build(graphite);
        long initialDelay=(((new Date().getTime()+exportInterval)/exportInterval)*exportInterval)-new Date().getTime();

        if(!dryRun){
            remoteReporter.start(initialDelay,exportInterval, TimeUnit.MILLISECONDS);
            logger.warning("DRYRUN IN FALSE, REPORTING...");
        }

    }
}