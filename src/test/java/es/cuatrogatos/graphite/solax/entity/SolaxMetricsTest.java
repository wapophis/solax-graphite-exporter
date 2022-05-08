package es.cuatrogatos.graphite.solax.entity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolaxMetricsTest {

    private static SolaxMetrics meter=new SolaxMetrics(System.getProperty("token"),System.getProperty("sn"));

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAcPower() {
        Assert.assertNotNull(meter.getAcPower().getValue());
    }

    @Test
    public void getYieldToday() {
        Assert.assertNotNull(meter.getYieldToday().getValue());
    }

    @Test
    public void getYieldTotal() {
        Assert.assertNotNull(meter.getYieldTotal().getValue());
    }

    @Test
    public void getFeedinpower() {
        Assert.assertNotNull(meter.getFeedinpower().getValue());
    }

    @Test
    public void getFeedinenergy() {
        Assert.assertNotNull(meter.getFeedinenergy().getValue());
    }

    @Test
    public void getConsumeenergy() {
        Assert.assertNotNull(meter.getConsumeenergy().getValue());
    }

    @Test
    public void getFeedinpowerM2() {
        Assert.assertNotNull(meter.getFeedinpowerM2().getValue());
    }

    @Test
    public void getSoc() {
        Assert.assertNotNull(meter.getSoc().getValue());
    }

    @Test
    public void getPeps1() {
        Assert.assertNotNull(meter.getPeps1().getValue());
    }

    @Test
    public void getPeps2() {
        Assert.assertNotNull(meter.getPeps2().getValue());
    }

    @Test
    public void getPeps3() {
        Assert.assertNotNull(meter.getPeps3().getValue());
    }

    @Test
    public void getInverterStatus() {
        Assert.assertNotNull(meter.getInverterStatus().getValue());
    }

    @Test
    public void getBatPower() {
        Assert.assertNotNull(meter.getBatPower().getValue());
    }

    @Test
    public void getPowerdc1() {
        Assert.assertNotNull(meter.getPowerdc1().getValue());
    }

    @Test
    public void getPowerdc2() {
        Assert.assertNotNull(meter.getPowerdc2().getValue());
    }

    @Test
    public void getPowerdc3() {
        Assert.assertNotNull(meter.getPowerdc3().getValue());
    }

    @Test
    public void getPowerdc4() {
        Assert.assertNotNull(meter.getPowerdc4().getValue());
    }
}