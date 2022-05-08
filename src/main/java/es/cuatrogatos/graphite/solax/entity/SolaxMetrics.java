package es.cuatrogatos.graphite.solax.entity;

import com.codahale.metrics.Gauge;
import es.cuatrogatos.solax.boundary.SolaxClient;

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class SolaxMetrics {

    private static Logger myLogger=Logger.getLogger(SolaxMetrics.class.getName());
    private SolaxClient client;

    public SolaxMetrics(SolaxClient client){
        this.client=client;
    }

    public SolaxMetrics(String tokenId,String sn){
        try {
            this.client=new SolaxClient("https://www.solaxcloud.com:9443/proxy/api/",tokenId,sn);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("CANNOT GET CLIENT BECAUSE OF "+e.getMessage());
        }
    }

    public Gauge<Double > getAcPower(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getAcpower();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getAcPower",e);
                    return null;
                }
            }
        };
    }

    public Gauge<Double > getYieldToday(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getYieldtoday();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getYieldToday",e);
                    return null;
                }
            }
        };
    }

    public Gauge<Double > getYieldTotal(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getYieldtotal();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getYieldTotal",e);
                    return null;
                }
            }
        };
    }

    public Gauge<Double > getFeedinpower(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getFeedinpower();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getFeedinpower",e);
                    return null;
                }
            }
        };
    }


    public Gauge<Double > getFeedinenergy(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getFeedinenergy();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getFeedinenergy",e);
                    return null;
                }
            }
        };
    }


    public Gauge<Double > getConsumeenergy(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getConsumeenergy();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getConsumeenergy",e);
                    return null;
                }
            }
        };
    }


    public Gauge<Double > getFeedinpowerM2(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getFeedinpowerM2();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getFeedinpowerM2",e);
                    return null;
                }
            }
        };
    }

    public Gauge<Double > getSoc(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getSoc();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getSoc",e);
                    return null;
                }
            }
        };
    }

    public Gauge<Double > getPeps1(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getPeps1();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getPeps1",e);
                    return null;
                }
            }
        };
    }

    public Gauge<Double > getPeps2(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getPeps2();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getPeps2",e);
                    return null;
                }
            }
        };
    }

    public Gauge<Double > getPeps3(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getPeps3();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getPeps3",e);
                    return null;
                }
            }
        };
    }

    public Gauge<Integer > getInverterStatus(){
        return new Gauge<Integer>() {
            @Override
            public Integer getValue() {
                try {
                    return Integer.valueOf(client.queryEndpoint().getResult().getInverterStatus());
                } catch (ExecutionException | InterruptedException e) {
                    logException("getInverterStatus",e);
                    return null;
                }
            }
        };
    }


    public Gauge<Double > getBatPower(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getBatPower();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getBatPower",e);
                    return null;
                }
            }
        };
    }

    public Gauge<Double > getPowerdc1(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getPowerdc1();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getPowerdc1",e);
                    return null;
                }
            }
        };
    }

    public Gauge<Double > getPowerdc2(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getPowerdc2();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getPowerdc2",e);
                    return null;
                }
            }
        };
    }

    public Gauge<Double > getPowerdc3(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getPowerdc3();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getPowerdc3",e);
                    return null;
                }
            }
        };
    }


    public Gauge<Double > getPowerdc4(){
        return new Gauge<Double>() {
            @Override
            public Double getValue() {
                try {
                    return client.queryEndpoint().getResult().getPowerdc4();
                } catch (ExecutionException | InterruptedException e) {
                    logException("getPowerdc4",e);
                    return null;
                }
            }
        };
    }

    private void logException(String sourceMethod,Exception e){
        myLogger.throwing(this.getClass().getName(),sourceMethod,e);
    }

}
