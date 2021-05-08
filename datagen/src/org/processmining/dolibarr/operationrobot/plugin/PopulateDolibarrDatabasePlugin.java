//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.processmining.dolibarr.operationrobot.plugin;

import com.fluxicon.slickerbox.components.IconVerticalTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.processmining.contexts.uitopia.UIPluginContext;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.contexts.uitopia.annotations.Visualizer;
import org.processmining.dolibarr.operationrobot.panels.BuildClickInterface;
import org.processmining.dolibarr.operationrobot.panels.RunDolibarrPanel;
import org.processmining.framework.plugin.annotations.Plugin;

public class PopulateDolibarrDatabasePlugin extends JPanel {
    private static final long serialVersionUID = 1L;
    protected BuildClickInterface simulationLogPanel;
    protected RunDolibarrPanel runDolibarrPanel;
    private static final String DASHBOARDICON = "clicklist.png";
    private static final String INSPECTORICON = "run.png";
    protected Image dashboardIcon = (new ImageIcon(PopulateDolibarrDatabasePlugin.class.getResource("clicklist.png"), "clicklist.png")).getImage();
    protected Image inspectorIcon = (new ImageIcon(PopulateDolibarrDatabasePlugin.class.getResource("run.png"), "run.png")).getImage();
    JTextField selectedPath;
    JTextField selectedConfigurationFilePath;

    public PopulateDolibarrDatabasePlugin() {
    }

    @Plugin(
            name = "ERP Data Generator",
            parameterLabels = {},
            returnLabels = {"ERP Data Generator"},
            returnTypes = {PopulateDolibarrDatabaseObject.class},
            userAccessible = true,
            help = "Start up editor"
    )
    @UITopiaVariant(
            affiliation = "Eindhoven University of Technology",
            author = "Guangming Li",
            email = "g.li.3@tue.nl"
    )
    public PopulateDolibarrDatabaseObject populateDolibarrDatabase(UIPluginContext context) throws Exception {
        context.log("ERP Data Generator starts");
        this.populateDolibarrDatabasePanel(context);
        return new PopulateDolibarrDatabaseObject(this);
    }

    @Plugin(
            name = "ERP Data Generator Visualization",
            parameterLabels = {"visualizer"},
            returnTypes = {JComponent.class},
            returnLabels = {"ERP Data Generator Visualization"},
            help = "ERP Data Generator"
    )
    @Visualizer
    public JComponent visualizePopulateDolibarrDatabase(UIPluginContext context, PopulateDolibarrDatabaseObject input) {
        System.out.println("ERP Data Generator visualizer");
        context.log("welcome ERP Data Generator visualizer");
        JPanel resultPanel = input.panel;
        return resultPanel;
    }

    public JComponent populateDolibarrDatabasePanel(UIPluginContext context) throws Exception {
        this.initialize((String)null);
        this.completeGui();
        return this;
    }

    protected void initialize(String path) {
        this.setBackground(new Color(40, 40, 40));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setLayout(new BorderLayout());
    }

    protected void completeGui() throws Exception {
        this.runDolibarrPanel = new RunDolibarrPanel(this);
        this.simulationLogPanel = new BuildClickInterface(this);
        IconVerticalTabbedPane iconTabs = new IconVerticalTabbedPane(new Color(230, 230, 230, 210), new Color(20, 20, 20, 160));
        iconTabs.addTab("Build Clicks", this.dashboardIcon, new JScrollPane(this.simulationLogPanel));
        iconTabs.addTab("Run System", this.inspectorIcon, new JScrollPane(this.runDolibarrPanel));
        this.add(iconTabs, "Center");
        this.revalidate();
        this.repaint();
    }

    public RunDolibarrPanel getRunDolibarrPanel() {
        return this.runDolibarrPanel;
    }

    public BuildClickInterface getSimulationLogPanel() {
        return this.simulationLogPanel;
    }

    public static void main(String[] args) throws Exception {
        PopulateDolibarrDatabasePlugin plugin = new PopulateDolibarrDatabasePlugin();
        JPanel ret = (JPanel)plugin.populateDolibarrDatabasePanel((UIPluginContext)null);
        JFrame frame = new JFrame();
        frame.getContentPane().add(ret);
        frame.setExtendedState(6);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }
}
