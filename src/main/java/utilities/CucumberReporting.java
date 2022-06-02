package utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

public class CucumberReporting {
	
public static void reportConfig () {
		
		File reportOutputDirectory = new File("target");
		
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target\\cucumber.json");
//		jsonFiles.add("cucumber-report-2.json");
//		File reportOutputDirectory = new File ("target"); 
//		
//		List <String> jsonFiles = new ArrayList <>(); 
//		jsonFiles.add("target\\cucumber.json"); 
//		
//		String buildNumber = "1"; 
//		String projectName = "Tek School Retail Website - Hawks"; 

		String buildNumber = "1";
		String projectName = "Tek School Hotel Website - Hawks";

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration - check javadoc for details
		configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
		// do not make scenario failed when step has status SKIPPED
		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		configuration.setBuildNumber(buildNumber);
		// addidtional metadata presented on main page
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "chrome");
		configuration.addClassifications("Branch", "release/1.0");

		// optionally add metadata presented on main page via properties file
//		List<String> classificationFiles = new ArrayList<>();
//		classificationFiles.add("properties-1.properties");
//		classificationFiles.add("properties-2.properties");
//		configuration.addClassificationFiles(classificationFiles);

	

		        ReportBuilder reportBuilder=new ReportBuilder(jsonFiles,configuration);
		        Reportable result=reportBuilder.generateReports();
		// and here validate 'result' to decide what to do if report has failed
//		
//		
//		Configuration configuration = new Configuration (reportOutputDirectory, projectName); 
//		configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
//		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
//		configuration.setBuildNumber(buildNumber);
//		configuration.addClassifications("Platform", "Windows");
//		configuration.addClassifications("Browser", "chrome");
//		configuration.addClassifications("Branch", "release/1.0");
//		ReportBuilder reportBuilder = new ReportBuilder (jsonFiles, configuration); 
//		Reportable result = reportBuilder.generateReports(); 
}

}
