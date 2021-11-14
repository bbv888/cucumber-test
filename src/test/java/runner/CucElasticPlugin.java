package runner;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.araj.cucumber.elasticsearch.exceptions.CucElasticPluginException;
import com.araj.cucumber.elasticsearch.filesystem.FileIO;
import com.araj.cucumber.elasticsearch.filesystem.FileSystemManager;
import com.araj.cucumber.elasticsearch.json.JsonPojoConverter;
import com.araj.cucumber.elasticsearch.json.pojo.Report;
import com.araj.cucumber.elasticsearch.logging.CucElasticPluginLogger;
import com.araj.cucumber.elasticsearch.pojos.collections.AllScenariosCollection;
import com.araj.cucumber.elasticsearch.properties.PropertyManager;
import com.araj.cucumber.elasticsearch.utils.CucElasticPluginReportGenerator;
import org.apache.maven.plugin.AbstractMojo;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

public class CucElasticPlugin extends AbstractMojo {
    private final CucElasticPluginLogger logger;
    private final PropertyManager propertyManager;
    private final FileSystemManager fileSystemManager;
    private final FileIO fileIO;
    private final JsonPojoConverter jsonPojoConverter;
    private final CucElasticPluginReportGenerator reportGenerator;

    public CucElasticPlugin(CucElasticPluginLogger logger, PropertyManager propertyManager, FileSystemManager fileSystemManager, FileIO fileIO, JsonPojoConverter jsonPojoConverter, CucElasticPluginReportGenerator reportGenerator) {
        this.propertyManager = propertyManager;
        this.fileSystemManager = fileSystemManager;
        this.fileIO = fileIO;
        this.jsonPojoConverter = jsonPojoConverter;
        this.logger = logger;
        this.reportGenerator = reportGenerator;
    }

    public void execute() throws CucElasticPluginException {
        this.logger.setMojoLogger(this.getLog());


        this.propertyManager.validateSettings();
        this.logger.info("-----------------------------------------------");
        this.logger.info(String.format(" Cucumber Report Maven Plugin, version %s", this.getClass().getPackage().getImplementationVersion()));
        this.logger.info("-----------------------------------------------");
        this.propertyManager.logProperties();
        AllScenariosCollection allScenariosPageCollection = new AllScenariosCollection();
        List<Path> jsonFilePaths = this.fileSystemManager.getJsonFilePaths(this.propertyManager.getSourceJsonReportDirectory());
        Iterator var3 = jsonFilePaths.iterator();

        while (var3.hasNext()) {
            Path jsonFilePath = (Path) var3.next();
            String jsonString = this.fileIO.readContentFromFile(jsonFilePath.toString());

            try {
                Report[] reports = this.jsonPojoConverter.convertJsonToReportPojos(jsonString);
                allScenariosPageCollection.addReports(reports);
            } catch (CucElasticPluginException var7) {
                this.logger.error("Could not parse JSON in file '" + jsonFilePath.toString() + "': " + var7.getMessage());
            }
        }

        this.reportGenerator.generateAndSendReportDocumentsForElasticSearch(allScenariosPageCollection);

    }
}
