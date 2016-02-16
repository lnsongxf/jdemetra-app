/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.nbdemetra.ui.tools;

import ec.nbdemetra.ui.ActiveViewManager;
import ec.nbdemetra.ui.IActiveView;
import ec.nbdemetra.ui.tsaction.ITsView2;
import ec.tss.Ts;
import ec.ui.view.AutoRegressiveSpectrumView;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JMenu;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.nodes.Sheet;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.Mode;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//ec.nbdemetra.ui.tools//AutoRegressiveSpectrum//EN",
autostore = false)
@TopComponent.Description(preferredID = "AutoRegressiveSpectrumTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_NEVER)
@TopComponent.Registration(mode = "output", openAtStartup = false)
@ActionID(category = "Window", id = "ec.nbdemetra.ui.tools.AutoRegressiveSpectrumTopComponent")
@ActionReference(path = "Menu/Tools/Spectral analysis", position = 100)
@TopComponent.OpenActionRegistration(displayName = "#CTL_AutoRegressiveSpectrumAction")
@Messages({
    "CTL_AutoRegressiveSpectrumAction=Auto-regressive Spectrum",
    "CTL_AutoRegressiveSpectrumTopComponent=Auto-regressive spectrum Window",
    "HINT_AutoRegressiveSpectrumTopComponent=This is a Auto-regressive spectrum window"
})
public final class AutoRegressiveSpectrumTopComponent extends TopComponent implements ITsView2, IActiveView, ExplorerManager.Provider {

    private AutoRegressiveSpectrumView view;
    private Node node;

    public AutoRegressiveSpectrumTopComponent() {
        initComponents();
        node = new InternalNode();
        view = new AutoRegressiveSpectrumView();
        add(view);
        setName(Bundle.CTL_AutoRegressiveSpectrumTopComponent());
        setToolTipText(Bundle.HINT_AutoRegressiveSpectrumTopComponent());
        associateLookup(ExplorerUtils.createLookup(ActiveViewManager.getInstance().getExplorerManager(), getActionMap()));
    }

    @Override
    public void open() {
        super.open();
        Mode mode = WindowManager.getDefault().findMode("output");
        if (mode != null && mode.canDock(this)) {
            mode.dockInto(this);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    @Override
    public void componentActivated() {
        ActiveViewManager.getInstance().set(this);
    }

    @Override
    public void componentDeactivated() {
        ActiveViewManager.getInstance().set(null);
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    public Ts getTs() {
        return null;
    }

    @Override
    public void setTs(Ts ts) {
        view.setTs(ts);
    }

    @Override
    public boolean fill(JMenu menu) {
        return false;
    }

    @Override
    public Node getNode() {
        return node;
    }

    @Override
    public ExplorerManager getExplorerManager() {
        return ActiveViewManager.getInstance().getExplorerManager();
    }

    @Override
    public boolean hasContextMenu() {
        return false;
    }

    class InternalNode extends AbstractNode {
        @Messages({
            "autoregressiveSpectrumTopComponent.internalNode.displayName=Auto-regressive spectrum"
        })
        InternalNode() {
            super(Children.LEAF);
            setDisplayName(Bundle.autoregressiveSpectrumTopComponent_internalNode_displayName());
        }

        @Override
        @Messages({
            "autoregressiveSpectrumTopComponent.transform.name=Transform",
            "autoregressiveSpectrumTopComponent.transform.displayName=Transformation",
            "autoregressiveSpectrumTopComponent.log.name=Log",
            "autoregressiveSpectrumTopComponent.log.desc=When marked, logarithmic transformation is used.",
            "autoregressiveSpectrumTopComponent.differencing.name=Differencing",
            "autoregressiveSpectrumTopComponent.differencing.desc=An order of a regular differencing of the series.",
            "autoregressiveSpectrumTopComponent.differencingLag.name=Differencing lag",
            "autoregressiveSpectrumTopComponent.differencingLag.desc=A number of lags used to take differences. For example, if Differencing lag = 3 then the differencing filter does not apply to the first lag (default) but to the third lag.",
            "autoregressiveSpectrumTopComponent.lastYears.name=Last years",
            "autoregressiveSpectrumTopComponent.lastYears.desc=A number of years of observations at the end of the time series used to produce the autoregressive spectrum (0=the whole time series is considered.",
            "autoregressiveSpectrumTopComponent.autoRegressiveSpectrum.name=Auto-regressive Spectrum",
            "autoregressiveSpectrumTopComponent.autoRegressiveSpectrum.displayName=Auto-regressive Spectrum",
            "autoregressiveSpectrumTopComponent.autoRegressivePolynomialOrder.name=Auto–regressive polynomial order",
            "autoregressiveSpectrumTopComponent.autoRegressivePolynomialOrder.desc=The number of lags in the AR model that is used to estimate the spectral density.",
            "autoregressiveSpectrumTopComponent.resolution.name=Resolution",
            "autoregressiveSpectrumTopComponent.resolution.desc=Parameter to the precision of the spectral density estimate grid."
        })
        protected Sheet createSheet() {
            Sheet sheet = super.createSheet();
            Sheet.Set transform = Sheet.createPropertiesSet();
            transform.setName(Bundle.autoregressiveSpectrumTopComponent_transform_name());
            transform.setDisplayName(Bundle.autoregressiveSpectrumTopComponent_transform_displayName());
            Node.Property<Boolean> log = new Node.Property(Boolean.class) {

                @Override
                public boolean canRead() {
                    return true;
                }

                @Override
                public Object getValue() throws IllegalAccessException, InvocationTargetException {
                    return view.isLogTransformation();
                }

                @Override
                public boolean canWrite() {
                    return true;
                }

                @Override
                public void setValue(Object t) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    view.setLogTransformation((Boolean) t);
                }
            };

            log.setName(Bundle.autoregressiveSpectrumTopComponent_log_name());
            log.setShortDescription(Bundle.autoregressiveSpectrumTopComponent_log_desc());
            transform.put(log);

            Node.Property<Integer> diff = new Node.Property(Integer.class) {

                @Override
                public boolean canRead() {
                    return true;
                }

                @Override
                public Object getValue() throws IllegalAccessException, InvocationTargetException {
                    return view.getDifferencingOrder();
                }

                @Override
                public boolean canWrite() {
                    return true;
                }

                @Override
                public void setValue(Object t) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    view.setDifferencingOrder((Integer) t);
                }
            };
            diff.setName(Bundle.autoregressiveSpectrumTopComponent_differencing_name());
            diff.setShortDescription(Bundle.autoregressiveSpectrumTopComponent_differencing_desc());
            transform.put(diff);

            Node.Property<Integer> diffLag = new Node.Property(Integer.class) {

                @Override
                public boolean canRead() {
                    return true;
                }

                @Override
                public Object getValue() throws IllegalAccessException, InvocationTargetException {
                    return view.getDifferencingLag();
                }

                @Override
                public boolean canWrite() {
                    return true;
                }

                @Override
                public void setValue(Object t) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    view.setDifferencingLag((Integer) t);
                }
            };
            diffLag.setName(Bundle.autoregressiveSpectrumTopComponent_differencingLag_name());
            diffLag.setShortDescription(Bundle.autoregressiveSpectrumTopComponent_differencingLag_desc());
            transform.put(diffLag);

             Node.Property<Integer> length = new Node.Property(Integer.class) {

                @Override
                public boolean canRead() {
                    return true;
                }

                @Override
                public Object getValue() throws IllegalAccessException, InvocationTargetException {
                    return view.getLastYears();
                }

                @Override
                public boolean canWrite() {
                    return true;
                }

                @Override
                public void setValue(Object t) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    view.setLastYears((Integer) t);
                }
            };
            length.setName(Bundle.autoregressiveSpectrumTopComponent_lastYears_name());
            length.setShortDescription(Bundle.autoregressiveSpectrumTopComponent_lastYears_desc());
            transform.put(length);

            Sheet.Set spectrum = Sheet.createPropertiesSet();
            spectrum.setName(Bundle.autoregressiveSpectrumTopComponent_autoRegressiveSpectrum_name());
            spectrum.setDisplayName(Bundle.autoregressiveSpectrumTopComponent_autoRegressiveSpectrum_displayName());
            
            Property<Integer> arcount = new Property(Integer.class) {

                @Override
                public boolean canRead() {
                    return true;
                }

                @Override
                public Object getValue() throws IllegalAccessException, InvocationTargetException {
                    return view.getArCount();
                }

                @Override
                public boolean canWrite() {
                    return true;
                }

                @Override
                public void setValue(Object t) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    view.setArCount((Integer) t);
                }
            };
            arcount.setName(Bundle.autoregressiveSpectrumTopComponent_autoRegressivePolynomialOrder_name());
            arcount.setShortDescription(Bundle.autoregressiveSpectrumTopComponent_autoRegressivePolynomialOrder_desc());
            spectrum.put(arcount);
            
            Property<Integer> resolution = new Property(Integer.class) {

                @Override
                public boolean canRead() {
                    return true;
                }

                @Override
                public Object getValue() throws IllegalAccessException, InvocationTargetException {
                    return view.getResolution();
                }

                @Override
                public boolean canWrite() {
                    return true;
                }

                @Override
                public void setValue(Object t) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    view.setResolution((Integer) t);
                }
            };
            resolution.setName(Bundle.autoregressiveSpectrumTopComponent_resolution_name());
            resolution.setShortDescription(Bundle.autoregressiveSpectrumTopComponent_resolution_desc());
            spectrum.put(resolution);
            
            sheet.put(transform);
            sheet.put(spectrum);
            return sheet;
        }
    }
}
