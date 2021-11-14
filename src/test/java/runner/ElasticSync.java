package runner;

import com.araj.cucumber.elasticsearch.filesystem.FileIO;
import com.araj.cucumber.elasticsearch.filesystem.FileSystemManager;
import com.araj.cucumber.elasticsearch.json.JsonPojoConverter;
import com.araj.cucumber.elasticsearch.json.postprocessors.ElementPostProcessor;
import com.araj.cucumber.elasticsearch.json.postprocessors.ReportPostProcessor;
import com.araj.cucumber.elasticsearch.logging.CucElasticPluginLogger;
import com.araj.cucumber.elasticsearch.pojos.ResultSender;
import com.araj.cucumber.elasticsearch.properties.PropertyManager;
import com.araj.cucumber.elasticsearch.utils.CucElasticPluginReportGenerator;

public class ElasticSync {
    public static void main(String[] args) throws Exception {

        CucElasticPluginLogger logger = new CucElasticPluginLogger();

        FileSystemManager fileSystemManager = new FileSystemManager();

        FileIO fileIO = new FileIO();

        //logger.setMojoLogger();//might need to add
        PropertyManager propertyManager = new PropertyManager(logger);
        propertyManager.setElasticSearchHostName("192.168.178.30:9200");
        propertyManager.setFeatureSummaryIndex("feature_summary_index");
        propertyManager.setFeatureSummaryDocumentType("feature_summary_document_type");
        propertyManager.setScenarioSummaryIndex("scenario_summary_index");
        propertyManager.setScenarioSummaryDocumentType("scenario_summary_document_type");
        propertyManager.setStepSummaryIndex("step_summary_index");
        propertyManager.setStepSummaryDocumentType("step_summary_document_type");
        propertyManager.setTagSummaryIndex("tag_summary_index");
        propertyManager.setTagSummaryDocumentType("tag_summary_document_type");
        propertyManager.setSendFeatureSummaryToElasticSearch("true");
        propertyManager.setSendScenarioSummaryToElasticSearch("true");
        propertyManager.setSendStepSummaryToElasticSearch("true");
        propertyManager.setSendTagSummaryToElasticSearch("true");
        propertyManager.setSourceJsonReportDirectory("C:\\Users\\vtudo\\IdeaProjects\\Cucumber\\TST\\cucumber.json");

        JsonPojoConverter jsonPojoConverter =
                new JsonPojoConverter(new ReportPostProcessor(),
                        new ElementPostProcessor(propertyManager, fileIO, logger));

        CucElasticPluginReportGenerator cucElasticPluginReportGenerator =
                new CucElasticPluginReportGenerator(logger, propertyManager, new ResultSender(logger));


        CucElasticPlugin cucElasticPlugin = new CucElasticPlugin(logger, propertyManager, fileSystemManager,
                fileIO, jsonPojoConverter, cucElasticPluginReportGenerator);

        cucElasticPlugin.execute();
    }
}
